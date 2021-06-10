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
            <router-link :to="{ name: item.url }" class="text">
              {{ item.title }}
            </router-link>
          </v-list-item-title>
        </v-list-item>
      </v-list>
      <v-list v-if="user">
        <v-list-item>
          <v-list-item-title class="text-center">
            <div class="mt-2">
              <v-dialog v-model="dialog" persistent max-width="600px">
                <template v-slot:activator="{ on, attrs }">
                  <a class="text" v-bind="attrs" v-on="on">
                    {{ $local.vn.profile_tille }}
                  </a>
                </template>
                <v-card>
                  <v-card-title>
                    <span class="text-h5">{{ $local.vn.user_profile }}</span>
                  </v-card-title>
                  <v-card-text>
                    <v-container>
                      <v-row>
                        <v-col cols="12">
                          <v-text-field
                            :label="$local.vn.user_name"
                            :value="user.name"
                            required
                          ></v-text-field>
                        </v-col>
                        <v-col cols="12">
                          <v-text-field
                            :label="$local.vn.account_name"
                            :value="user.userName"
                            required
                          ></v-text-field>
                        </v-col>
                        <v-col cols="12">
                          <v-text-field
                            label="Email*"
                            :value="user.email"
                          ></v-text-field>
                        </v-col>
                        <v-col cols="12">
                          <v-text-field
                            :label="$local.vn.phone"
                            :value="user.phone"
                            required
                          ></v-text-field>
                        </v-col>
                      </v-row>
                    </v-container>
                  </v-card-text>
                  <v-card-actions>
                    <v-spacer></v-spacer>
                    <v-btn color="blue darken-1" text @click="dialog = false">
                      {{ $local.vn.close }}
                    </v-btn>
                  </v-card-actions>
                </v-card>
              </v-dialog>
            </div>
            <div class="mt-5">
              <a class="text" @click="logout"> {{ $local.vn.logout_title }} </a>
            </div>
          </v-list-item-title>
        </v-list-item>
      </v-list>
    </v-menu>
  </div>
</template>

<script>
export default {
  data() {
    return {
      dialog: false,
    }
  },
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
