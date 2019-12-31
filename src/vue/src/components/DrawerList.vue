<template>
  <div>
    <v-list>
      <router-link :to="action.href" link v-for="(action,index) in actions" :key="index">
        <v-list-item>
          <v-list-item-action>
            <v-icon>{{action.icon}}</v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title>{{action.describe}}</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </router-link>
    </v-list>
  </div>
</template>

<script>
export default {
  props: {
    actions: {
      type: Array,
      required: true
    }
  }
};
</script>

<style  scoped>
a {
  text-decoration: none;
}
</style>
