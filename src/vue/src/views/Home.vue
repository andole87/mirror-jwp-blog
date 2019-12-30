<template>
  <v-app id="myblog">
    <v-navigation-drawer v-model="drawer" app>
      <v-list dense>
        <v-list-item link>
          <v-list-item-action>
            <v-icon>mdi-home</v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title>Home</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list>
    </v-navigation-drawer>

    <v-app-bar app color="indigo" dark>
      <v-app-bar-nav-icon @click.stop="drawer = !drawer" />
      <v-spacer />
      <v-toolbar-title>나만의 블로그</v-toolbar-title>
      <v-spacer />
    </v-app-bar>

    <v-content>
      <v-container class="fill-height" fluid></v-container>
    </v-content>
    <v-footer color="indigo" app>
      <span class="white--text">&copy; 2019, andole</span>
    </v-footer>
  </v-app>
</template>

<script>
export default {
  data: () => ({
    drawer: false
  })
};
</script>