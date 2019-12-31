<template>
  <div>
    <v-row align="center" justify="center">
      <v-col cols="12" sm="8" md="4">
        <v-card class="elevation-12">
          <v-toolbar class="indigo" dark flat dense>
            <v-toolbar-title>로그인</v-toolbar-title>
          </v-toolbar>
          <v-card-text>
            <v-form>
              <v-text-field label="Email" name="login" prepend-icon="email" type="text" />
              <v-text-field label="Password" name="password" prepend-icon="lock" type="password" />
            </v-form>
          </v-card-text>
          <v-card-actions>
            <v-btn color="amber" dark>Oauth</v-btn>
            <v-spacer />
            <v-btn color="indigo" dark>로그인</v-btn>
          </v-card-actions>
        </v-card>
      </v-col>
    </v-row>
  </div>
</template>

<script>
export default {
  data: () => ({})
};
</script>