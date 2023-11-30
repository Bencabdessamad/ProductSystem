<template>
    <div class="my-admin-container">
      <div class="card">
        <div class="card-header">
          <h4>
            Admin
          </h4>
        </div>
        <div class="card-body">
          <table class="table table-bordered">
            <thead>
              <tr>
                <th></th>
                <th>nom</th>
                <th>prenom</th>
                <th>email</th>
                <th>password</th>
              </tr>
            </thead>
            <tbody>
              <tr v-for="admin in admins" :key="admin.id">
                <td style="text-align: center;"><svg xmlns="http://www.w3.org/2000/svg" height="2em" viewBox="0 0 448 512">
                  <path d="M304 128a80 80 0 1 0 -160 0 80 80 0 1 0 160 0zM96 128a128 128 0 1 1 256 0A128 128 0 1 1 96 128zM49.3 464H398.7c-8.9-63.3-63.3-112-129-112H178.3c-65.7 0-120.1 48.7-129 112zM0 482.3C0 383.8 79.8 304 178.3 304h91.4C368.2 304 448 383.8 448 482.3c0 16.4-13.3 29.7-29.7 29.7H29.7C13.3 512 0 498.7 0 482.3z"/>
                </svg></td>
                <td>{{ admin.nom }}</td>
                <td>{{ admin.prenom }}</td>
                <td>{{ admin.email }}</td>
                <td>{{ md5(admin.password) }}</td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>
    </template>
    <script>
    import axios from 'axios';
    import md5 from 'blueimp-md5';

    export default {
      name: 'admins',
      data() {
        return {
          admins: [],
        };
      },
      mounted() {
        this.getadmins();
      },
      methods: {
        getadmins() {
          axios.get('http://localhost:8081/api/admins').then((res) => {
            this.admins = res.data;
            console.log(this.admins);
          });
        },
        md5(string) {
          return md5(string); 
        },
      },
    };
    </script>
    <style>
    .my-admin-container {
      padding: 20px;
      background-color: #f0f0f0;
      border: 1px solid #ccc;
    }
    </style>
    