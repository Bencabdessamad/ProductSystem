<template>
    <div class="my-marque-container">
      <div class="card">
        <div class="card-header">
          <h4>Add Product</h4>
        </div>
        <div class="card-body">
          <div class="mb-3">
            <label for="nom">Nom<span style="color: red">*</span></label>
            <input type="text" id="nom" v-model="model.piece.nom" class="form-control" required/>
          </div>
          <div class="mb-3">
            <label for="marque">Marque<span style="color: red">*</span></label>
            <input type="text" id="marque" v-model="model.piece.marque" class="form-control" required/>
          </div>
          <div class="mb-3">
            <label for="categorie">Categorie<span style="color: red">*</span></label>
            <input type="text" id="categorie" v-model="model.piece.categorie" class="form-control" required/>
          </div>
          <div class="mb-3">
            <label for="description">Description<span style="color: red">*</span></label>
            <input type="text" id="description" v-model="model.piece.description" class="form-control" required/>
          </div>
          <div class="mb-3">
            <label for="quantite">Quantite<span style="color: red">*</span></label>
            <input type="text" id="quantite" v-model="model.piece.quantite" class="form-control" required/>
          </div>
          <div class="mb-3">
            <label for="prix_achat">Prix d'achat<span style="color: red">*</span></label>
            <input type="text" id="prix_achat" v-model="model.piece.prix_achat" class="form-control" required/>
          </div>
          <div class="mb-3">
            <label for="prix_vente">Prix de vente<span style="color: red">*</span></label>
            <input type="text" id="prix_vente" v-model="model.piece.prix_vente" class="form-control" required/>
          </div>
          <div class="button-container">
            <button type="button" @click="savePiece" class="btn btn-primary">Save</button>
            <router-link to="/piece" class="btn btn-primary">Back</router-link>
          </div>            
        </div>
      </div>
    </div>
  </template>
  
  <script>
  import axios from 'axios';
  
  export default {
    name: 'pieceCreate',
    data() {
      return {
        model: {
          piece: {
            nom: '',
            marque: '',
            categorie: '',
            description: '',
            quantite: '',
            prix_achat: '',
            prix_vente: '',
          },
        },
      };
    },
    methods: {
      savePiece() {
        if (
          !this.model.piece.nom ||
          !this.model.piece.marque ||
          !this.model.piece.categorie ||
          !this.model.piece.description ||
          !this.model.piece.quantite ||
          !this.model.piece.prix_achat ||
          !this.model.piece.prix_vente
        ) {
          alert('Veuillez remplir tous les champs obligatoires.');
        } else {
          axios.post('http://localhost:8081/api/pieces/save', this.model.piece).then((res) => {
            console.log(res.data);
            this.model.piece = {
              nom: '',
              marque: '',
              categorie: '',
              description: '',
              quantite: '',
              prix_achat: '',
              prix_vente: '',
            };
            this.$router.push('/piece');
          });
        }
      },
    },
  };
  </script>
  
  <style>
  .my-marque-container {
    padding: 20px;
    background-color: #f0f0f0;
    border: 1px solid #ccc;
  }
  .button-container {
    display: flex;
    gap: 10px;
  }
  </style>
  