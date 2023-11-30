<template>
    <div class="my-marque-container">
        <div class="card">
            <div class="card-header">
                <h4>Add Marques</h4>
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
                    <label for="description">Pays d'origine<span style="color: red">*</span></label>
                    <input type="text" v-model="model.marque.pays_origine" class="form-control" required/>
                </div>
                <div class="button-container">
                    <RouterLink to="/marque" type="button" @click="saveMarque" class="btn btn-primary">Save</RouterLink>
                    <router-link to="/marque" class="btn btn-primary">Back</router-link>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import axios from 'axios';

export default {
    name: 'marqueCreate',
    data() {
        return {
            model: {
                marque: {
                    nom: '',
                    description: '',
                    pays_origine: ''
                }
            }
        };
    },
    methods: {
        saveMarque() {
            if (
                !this.model.marque.nom ||
                !this.model.marque.description ||
                !this.model.marque.pays_origine
            ) {
                alert('Veuillez remplir tous les champs obligatoires.');
            } else {
                axios.post('http://localhost:8081/api/marques/save', this.model.marque)
                    .then((res) => {
                        console.log(res.data);
                        this.model.marque = {
                            nom: '',
                            description: '',
                            pays_origine: '',
                        };
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
