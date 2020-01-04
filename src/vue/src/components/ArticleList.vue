<template>
  <div>
    <v-row align="center" justify="center" v-for="(article, index) in articles" :key="index">
      <v-col cols="12" sm="8" md="8">
        <router-link :to="{name: 'article', params:{articleId:article.id}}">
          <v-card>
            <v-card-text>
              <p class="display-1 text--primary" align="center">{{article.title}}</p>
              <div class="text--primary">{{ article.contents }}</div>
            </v-card-text>
          </v-card>
        </router-link>
      </v-col>
    </v-row>
  </div>
</template>

<script>
export default {
  props: {
    articles: {
      type: Array,
      required: true
    }
  }
};
</script>

<style scoped>
a {
  text-decoration: none;
}
</style>