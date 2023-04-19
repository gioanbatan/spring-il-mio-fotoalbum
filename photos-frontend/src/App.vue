<script>
import axios from 'axios';
import AppHeader from "./components/AppHeader.vue";
import AppFooter from "./components/AppFooter.vue";

export default {
  name: 'App',
  data() {
    return {

    }
  },
  components: {
    AppHeader,
    AppFooter
  }
}

</script>
<template>
  <!-- header -->
  <header>
    <AppHeader />
  </header>
  <!-- /header -->

  <!-- main -->
  <router-view></router-view>
  <!-- /main -->


  <!-- footer -->
  <footer>
    <AppFooter />
  </footer>
  <!-- /footer -->
</template>
    

<style lang="scss">
@use "./style/general.scss" as *;
</style>