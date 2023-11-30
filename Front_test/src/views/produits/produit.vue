<template>
  <div class="my-produit-container">
    <div class="card">
      <div class="card-header">
        <h4>
          Product
          <RouterLink to="/piece/create" class="btn btn-outline-secondary float-end"> Add Product</RouterLink>
        </h4>
      </div>
      <div class="card-body">
        <div class="mb-3 search-bar">
          <input
            type="text"
            id="searchInput"
            v-model="searchQuery"
            class="form-control search-input"
            @input="searchPieces"
            placeholder="Search"
          />
          <button class="btn btn-outline-primary search-button" @click="searchPieces">Search</button>
        </div>
        <table class="table table-bordered">
          <thead>
            <tr>
              <th>nom</th>
              <th>marque</th>
              <th>categorie</th>
              <th>description</th>
              <th>quantite</th>
              <th>prix d'achat</th>
              <th>prix de vente</th>
              <th>Buy</th>
              <th>Action</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="piece in pieces" :key="piece.pieceId">
              <td>{{ piece.nom }}</td>
              <td>{{ piece.marque }}</td>
              <td>{{ piece.categorie }}</td>
              <td>{{ piece.description }}</td>
              <td>{{ piece.quantite }}</td>
              <td>{{ piece.prix_achat }}</td>
              <td>{{ piece.prix_vente }}</td>
              <td>
                <div class="buy-input">
                  <input v-model="quantities[piece.pieceId]" type="number" placeholder="Quantity" class="form-control search-input"/>
                  <button type="button" @click="buyPiece(piece)" class="btn btn-outline-primary search-button">Buy</button>
                </div>
              </td>                          
              <td>
                <RouterLink :to="{ path: '/pieces/' + piece.pieceId}" class="btn btn-outline-success">Edit</RouterLink>
                <button type="button" @click="deletePiece(piece.pieceId)" class="btn btn-outline-danger">Delete</button>
              </td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
export default {
  name: 'pieces',
  data() {
    return {
      pieces: [],
      searchQuery: '',
      buyQuantity: 0,
      quantities: {},
    };
  },
  mounted() {
    this.getPieces();
  },
  methods: {
    getPieces() {
      axios.get('http://localhost:8081/api/pieces')
        .then((res) => {
          this.pieces = res.data;
        })
        .catch((error) => {
          console.error("Erreur lors de la récupération des pièces : " + error);
        });
    },
    deletePiece(pieceId) {
      if (confirm('Are you sure you want to delete this piece?')) {
        axios.delete(`http://localhost:8081/api/pieces/delete/${pieceId}`)
          .then(() => {
            this.getPieces();
          })
          .catch((error) => {
            console.error("Erreur lors de la suppression de la pièce : " + error);
          });
      }
    },
    searchPieces() {
      if (this.searchQuery.trim() === '') {
        this.getPieces();
      } else {
        axios.get(`http://localhost:8081/api/pieces/rechercherPiece?nom=${this.searchQuery}`)
          .then((res) => {
            this.pieces = res.data;
          })
          .catch((error) => {
            console.error("Erreur lors de la recherche des pièces : " + error);
          });
      }
    },
    buyPiece(piece) {
  const { pieceId } = piece;
  const buyQuantity = parseInt(this.quantities[pieceId], 10);
  if (buyQuantity === '' || isNaN(buyQuantity)) {
    console.error("Veuillez entrer une quantité valide.");
    return this.quantities[pieceId] = '';
  }
  if (buyQuantity < 0) {
    console.error("Veuillez entrer une quantité positive.");
    return this.quantities[pieceId] = '';
  }
  axios.post('http://localhost:8081/api/pieces/decrementerPiece', { pieceId, buy: buyQuantity }, {
    headers: {
      'Content-Type': 'application/json',
    },
  })
    .then((res) => {
      const updatedPiece = res.data;
      this.quantities[pieceId] = '';
      const index = this.pieces.findIndex(p => p.pieceId === pieceId);
      if (index !== -1) {
        this.pieces[index] = { ...this.pieces[index], ...updatedPiece };
      }
      console.log(`Achat réussi de ${buyQuantity} unités de ${updatedPiece.nom}.`);
    })
    .catch((error) => {
      console.error('Erreur lors de l\'achat de la pièce :', error);
      console.error('Erreur lors de l\'achat de la pièce.'); 
    });
},
  },
};
</script>


<style>
.my-produit-container {
  padding: 20px;
  background-color: #f0f0f0;
  border: 1px solid #ccc;
}

.btn-outline-success {
  margin-right: 10px;
}

.btn-outline-danger {
  margin-left: 10px;
}

.search-bar {
  display: flex;
  align-items: center;
}

.search-input {
  flex: 1;
  margin-right: 10px;
  border-radius: 5px;
  padding: 8px 10px;
}

.search-button {
  border-radius: 5px;
  padding: 8px 15px;
}
.buy-input {
  display: flex;
  align-items: center; 
}

.buy-input input {
  margin-right: 10px;
}

.buy-input button {
  margin-left: 10px; 
}

</style>
