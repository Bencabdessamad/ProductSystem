<template>
  <div>
    <div v-if="notificationMessage" class="notification">
      {{ notificationMessage }}
    </div>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      notificationMessage: null
    };
  },
  mounted() {
    this.fetchNotificationMessage(); 
  },
  methods: {
    fetchNotificationMessage() {
      console.log('Envoi de la requête de notification...');
      axios.get('http://localhost:8081/api/pieces/notification')
        .then(response => {
          console.log('Réponse reçue :', response.data);
          this.notificationMessage = response.data;
          setTimeout(() => {
            this.notificationMessage = null;
          }, 10000);
        })
        .catch(error => {
          console.error('Erreur lors de la récupération de la notification', error);
        })
        .finally(() => {
          console.log('Planification de la prochaine récupération de notification dans 1 seconde...');
          setTimeout(this.fetchNotificationMessage, 10000);
        });
    }
  }
};
</script>


<style scoped>
.notification {
  border: 1px solid #ccc;
  padding: 10px;
  margin: 10px 0;
  background-color: #f2f2f2;
  border-radius: 4px;
}

</style>