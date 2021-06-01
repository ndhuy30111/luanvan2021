<template>
  <div class="acc text-center">
    <v-menu offset-y>
      <template #activator="{ on, attrs }">
        <v-btn v-bind="attrs" icon v-on="on">
          <b-icon id="person" icon="person-check"></b-icon>
        </v-btn>
        {{ user.name }}
      </template>
      <v-list v-if="!user">
        <v-list-item
          v-for="(item, index) in $local.vn.memu_account"
          :key="index"
        >
          <v-list-item-title class="text-center">
            <a :href="item.url" class="text">
              {{ item.title }}
            </a>
          </v-list-item-title>
        </v-list-item>
      </v-list>
      <v-list v-if="user">
        <v-list-item>
          <v-list-item-title class="text-center">
            <a class="text" @click="logout"> Dang xuat </a>
          </v-list-item-title>
        </v-list-item>
      </v-list>
    </v-menu>
  </div>
</template>

<script>
export default {
  computed: {
    user() {
      return this.$auth.user ? this.$auth.user : ''
    },
  },
  methods: {
    logout() {
      this.$auth.logout()
    },
  },
}
</script>

<style lang="scss" scoped>
.acc {
  margin: 0px 10px;
  #person {
    font-size: 1.5rem;
  }
}
a.text {
  color: rgb(0, 0, 0);
  text-decoration: none;
}
a:hover {
  color: #ce785c;
}
</style>
