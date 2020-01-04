<template>
  <div>
    <h2>{{article.title}}</h2>
    <p>{{article.contents}}</p>
  </div>
</template>
<script>
export default {
  props: {
    article: {
      type: Object,
      required: true
    }
  }
};
</script>