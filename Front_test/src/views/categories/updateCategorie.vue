<template>
    <div class="my-categorie-container">
        <div class="card">
            <div class="card-header">
                <h4>update Categories</h4>
            </div>
            <div class="card-body">
                <div class="mb-3">
                    <label for="nom">Nom<span style="color: red">*</span></label>
                    <input type="text" id="nom" v-model="model.categorie.nom" class="form-control" required/>
                </div>
                <div class="mb-3">
                    <label for="description">Description<span style="color: red">*</span></label>
                    <input type="text" id="description" v-model="model.categorie.description" class="form-control" required/>
                </div>
                <div class="button-container">
                    <RouterLink to="/categorie" type="button" @click="putCategorie" class="btn btn-primary">Save</RouterLink>
                    <router-link to="/categorie" class="btn btn-primary">Back</router-link>
                </div>
            </div>
        </div>
    </div>
</template>
<script>
import axios from 'axios';
export default {
    name: 'updateCategorie',
    data() {
        return {
            model: {
                categorie: {
                    nom: '',
                    description: ''
                }
            }
        }
    },
    mounted(){
        this.getCategorieData(this.$route.params.id);
    },
    methods: {
        getCategorieData(categorieId) {
            axios.get(`http://localhost:8081/api/categories/${categorieId}`).then(res => {
                console.log(res.data);
                this.model.categorie = res.data; 
            });
        },
        putCategorie() {
            axios.put(`http://localhost:8081/api/categories/update/${this.$route.params.id}`, this.model.categorie).then(res => {
                console.log(res.data);
                this.$router.push('/categorie'); 
                this.getCategories();
            });
        }
    }
}
</script>
<style>
.my-categorie-container {
    padding: 20px;
    background-color: #f0f0f0;
    border: 1px solid #ccc;
}
.button-container {
    display: flex;
    gap: 10px;
  }
</style>
