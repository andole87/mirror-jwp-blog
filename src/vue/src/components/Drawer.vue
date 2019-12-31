<template>
  <div>
    <v-navigation-drawer v-model="drawer" app>
      <DrawerList :actions="actions"></DrawerList>
      <template v-slot:append v-if="login">
        <v-btn color="pink lighten-2" dark block>로그아웃</v-btn>
      </template>
    </v-navigation-drawer>

    <v-app-bar app color="indigo" dark>
      <v-app-bar-nav-icon @click.stop="toggleDrawer" />
      <v-spacer />
      <v-toolbar-title>나만의 블로그</v-toolbar-title>
      <v-spacer />
    </v-app-bar>
  </div>
</template>

<script>
import DrawerList from "@/components/DrawerList.vue";
export default {
  components: {
    DrawerList
  },
  data() {
    return {
      actions: [
        { icon: "home", describe: "Home", href: "/" },
        { icon: "edit", describe: "글쓰기", href: "/articles/new" }
      ],
      login: false,
      drawer: false
    };
  },
  methods: {
    toggleDrawer() {
      this.drawer = !this.drawer;
    }
  }
};
</script>