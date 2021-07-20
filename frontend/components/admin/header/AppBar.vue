<template>
  <v-app-bar
    absolute
    color="white"
    elevate-on-scroll
    scroll-target="#scrolling-techniques-7"
    app
  >
    <v-app-bar-nav-icon @click="$emit('action')"></v-app-bar-nav-icon>
    <v-toolbar-title>{{ $local.vn_admin.admin }}</v-toolbar-title>
    <v-spacer></v-spacer>

    <v-btn icon>
      <v-icon>mdi-dots-vertical</v-icon>
    </v-btn>
  </v-app-bar>
</template>

<script>
export default {}
</script>

<style></style>
