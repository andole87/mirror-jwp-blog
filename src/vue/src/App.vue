<template>
  <v-app id="myblog">
    <Drawer></Drawer>
    <v-content>
      <v-container fluid>
        <v-layout>
          <v-flex>
            <router-view />
          </v-flex>
        </v-layout>
      </v-container>
    </v-content>
    <Footer></Footer>
  </v-app>
</template>

<script>
import Drawer from "@/components/Drawer.vue";
import Footer from "@/components/Footer.vue";
export default {
  name: "App",
  components: {
    Drawer,
    Footer
  }
};
</script>
