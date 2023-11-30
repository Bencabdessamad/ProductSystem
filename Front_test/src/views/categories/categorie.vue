<template>
  <div class="my-categorie-container">
    <div class="card">
      <div class="card-header">
        <h4>
          Categorie
          <RouterLink to="/Categorie/create" class="btn btn-outline-secondary float-end">Add Categorie</RouterLink>
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
              @input="searchCategories"
              placeholder="Search"
            />
            <button class="btn btn-outline-primary search-button" @click="searchCategories">Rechercher</button>
          </div>
        </div>

        <table class="table table-bordered">
          <thead>
            <tr>
              <th>nom</th>
              <th>description</th>
              <th>Action</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="categorie in categories" :key="categorie.categorieId">
              <td>{{categorie.nom}}</td>
              <td>{{categorie.description}}</td>
              <td>
                <RouterLink :to="{ path: '/categories/' + categorie.categorieId }" class="btn btn-outline-success">Edit</RouterLink>
                <button class="btn btn-outline-danger" @click="deleteCategorie(categorie.categorieId)">Delete</button>
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
  name: 'categories',
  data() {
    return {
      categories: [],
      searchQuery: '',
    };
  },
  mounted() {
    this.getCategories();
  },
  methods: {
    getCategories() {
      axios.get('http://localhost:8081/api/categories').then((res) => {
        this.categories = res.data;
      });
    },
    deleteCategorie(categorieId) {
      if (confirm('Are you sure you want to delete this data?')) {
        axios.delete(`http://localhost:8081/api/categories/delete/${categorieId}`).then((res) => {
          alert('Data deleted');
          this.getCategories();
        });
      }
    },
    searchCategories() {
      if (this.searchQuery.trim() === '') {
        this.getCategories();
      } else {
        axios.get(`http://localhost:8081/api/categories/rechercherCategorie?nom=${this.searchQuery}`).then((res) => {
          this.categories = res.data;
        });
      }
    },
  },
};
</script>

<style>
.my-categorie-container {
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
