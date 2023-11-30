<template>
  <div id="app">
    <Navbar v-if="!$route.meta.hideNavbar" />
    <router-view />
    <div class="footer" v-if="!$route.meta.hideFooter">
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import { useRoute } from 'vue-router';
import Navbar from "@/components/Navbar.vue";


const adminName = ref('abdessamad bencheraik');

onMounted(() => {
  document.title = 'Product';
  console.log('developed by :', adminName.value);
});

const route = useRoute();
const hideNavbar = ref(false);
const hideFooter = ref(false);

hideNavbar.value = route.meta.hideNavbar;
hideFooter.value = route.meta.hideFooter;
</script>
