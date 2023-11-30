<template>
    <div class="my-marque-container">
        <div class="card">
            <div class="card-header">
                <h4>Update Marques</h4>
            </div>
            <div class="card-body">
                <div class="mb-3">
                    <label for="nom">Nom<span style="color: red">*</span></label>
                    <input type="text" v-model="model.marque.nom" class="form-control" required/>
                </div>
                <div class="mb-3">
                    <label for="description">Description<span style="color: red">*</span></label>
                    <input type="text" v-model="model.marque.description" class="form-control" required/>
                </div>
                <div class="mb-3">
                    <label for="pays_origine">Pays d'origine<span style="color: red">*</span></label>
                    <input type="text" v-model="model.marque.pays_origine" class="form-control" required/>
                </div>
                <div class="button-container">
                    <button type="button" @click="updateMarque" class="btn btn-primary">Save</button>
                    <router-link to="/marque" class="btn btn-primary">Back</router-link>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import axios from 'axios';

export default {
    name: 'updateMarque',
    data() {
        return {
            model: {
                marque: {
                    nom: '',
                    description: '',
                    pays_origine: ''
                }
            }
        }
    },
    mounted() {
        this.getMarqueData(this.$route.params.id);
    },
    methods: {
        getMarqueData(marqueId) {
            axios.get(`http://localhost:8081/api/marques/${marqueId}`).then(res => {
                this.model.marque = res.data;
            });
        },
        updateMarque() {
            axios.put(`http://localhost:8081/api/marques/update/${this.$route.params.id}`, this.model.marque)
                .then(res => {
                    console.log(res.data);
                    this.$router.push('/marque'); 
                });
        }
    }
}
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
