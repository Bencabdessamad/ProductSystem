<template>
  <div class="my-marque-container">
    <div class="card">
      <div class="card-header">
        <h4>
          Marque
          <RouterLink to="/marque/create" class="btn btn-outline-secondary float-end">Add Marque</RouterLink>
        </h4>
      </div>
      <div class="card-body">
        <div class="mb-3">
          <div class="search-bar">
            <input
              type="text"
              id="searchInput"
              v-model="searchQuery"
              class="form-control search-input"
              @input="searchMarques"
              placeholder="Search"
            />
            <button class="btn btn-outline-primary search-button" @click="searchMarques">Rechercher</button>
          </div>
        </div>
        <table class="table table-bordered">
          <thead>
            <tr>
              <th>nom</th>
              <th>description</th>
              <th>pays_origine</th>
              <th>Action</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="marque in marques" :key="marque.marqueId">
              <td>{{marque.nom}}</td>
              <td>{{marque.description}}</td>
              <td>{{marque.pays_origine}}</td>
              <td>
                <RouterLink :to="{ path: '/marques/' + marque.marqueId}" class="btn btn-outline-success">Edit</RouterLink>
                <button type="button" @click="deleteMarque(marque.marqueId)" class="btn btn-outline-danger ">Delete</button>
              </td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  name: 'marques',
  data() {
    return {
      marques: [],
      searchQuery: '',
    };
  },
  mounted() {
    this.getMarques();
  },
  methods: {
    getMarques() {
      axios.get('http://localhost:8081/api/marques').then((res) => {
        this.marques = res.data;
      });
    },
    deleteMarque(marqueId) {
      if (confirm('Are you sure you want to delete this data?')) {
        axios.delete(`http://localhost:8081/api/marques/delete/${marqueId}`).then(() => {
          this.getMarques();
        });
      }
    },
    searchMarques() {
      if (this.searchQuery.trim() === '') {
        this.getMarques();
      } else {
        axios.get(`http://localhost:8081/api/marques/rechercherMarque?nom=${this.searchQuery}`).then((res) => {
          this.marques = res.data;
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
</style>
