<template>
  <v-container>
    <v-row>
      <v-col>
        <v-data-table
          :headers="$local.vn_admin.color_headers"
          :items="dataColor"
          sort-by="calories"
          class="elevation-1"
        >
          <template #[`item.code`]="{ item }">
            <v-chip :color="item.code">
              {{ item.code }}
            </v-chip>
          </template>
          <template #[`top`]>
            <v-toolbar flat>
              <v-toolbar-title>{{
                $local.vn_admin.color_title
              }}</v-toolbar-title>
              <v-divider class="mx-4" inset vertical></v-divider>
              <v-spacer></v-spacer>
              <v-dialog v-model="dialog" max-width="500px">
                <template #[`activator`]="{ on, attrs }">
                  <v-btn
                    color="primary"
                    dark
                    class="mb-2"
                    v-bind="attrs"
                    v-on="on"
                  >
                    {{ $local.vn_admin.add_color }}
                  </v-btn>
                </template>
                <v-card>
                  <v-card-title>
                    <span class="headline">{{ formTitle }}</span>
                  </v-card-title>

                  <v-card-text>
                    <v-container>
                      <v-row>
                        <v-col cols="12" sm="6" md="6">
                          <v-text-field
                            v-model="name"
                            label="Tên"
                            required
                          ></v-text-field>
                        </v-col>
                        <v-col cols="12" sm="6" md="6">
                          <v-text-field
                            v-model="color"
                            hide-details
                            solo
                            class="ma-0 pa-0"
                          >
                            <template #append>
                              <v-menu
                                v-model="menu"
                                top
                                nudge-bottom="105"
                                nudge-left="16"
                                :close-on-content-click="false"
                              >
                                <template #activator="{ on }">
                                  <div :style="swatchStyle" v-on="on" />
                                </template>
                                <v-card>
                                  <v-card-text class="pa-0">
                                    <v-color-picker v-model="color" flat />
                                  </v-card-text>
                                </v-card>
                              </v-menu>
                            </template>
                          </v-text-field>
                        </v-col>
                      </v-row>
                    </v-container>
                  </v-card-text>

                  <v-card-actions>
                    <v-spacer></v-spacer>
                    <v-btn color="blue darken-1" text @click="close">
                      Cancel
                    </v-btn>
                    <v-btn color="blue darken-1" text @click="save">
                      Save
                    </v-btn>
                  </v-card-actions>
                </v-card>
              </v-dialog>
              <v-dialog v-model="dialogDelete" max-width="500px">
                <v-card>
                  <v-card-title class="headline">{{
                    $local.vn_admin.delete_msg
                  }}</v-card-title>
                  <v-card-actions>
                    <v-spacer></v-spacer>
                    <v-btn color="blue darken-1" text @click="closeDelete"
                      >Cancel</v-btn
                    >
                    <v-btn color="blue darken-1" text @click="deleteItemConfirm"
                      >OK</v-btn
                    >
                    <v-spacer></v-spacer>
                  </v-card-actions>
                </v-card>
              </v-dialog>
            </v-toolbar>
          </template>
          <template #[`item.actions`]="{ item }">
            <v-icon small class="mr-2" @click="editItem(item)">
              mdi-pencil
            </v-icon>
            <v-icon small @click="deleteItem(item)"> mdi-delete </v-icon>
          </template>
        </v-data-table></v-col
      ></v-row
    >
  </v-container>
</template>

<script>
export default {
  layout: 'admin',
  data: () => ({
    dialog: false,
    dialogDelete: false,
    editedIndex: -1,
    name: '',
    color: '#FF00FF',
    menu: false,
  }),
  head() {
    return {
      title: this.$local.vn_admin.color_title,
      meta: [
        {
          hid: this.$local.vn_admin.color_title,
          name: this.$local.vn_admin.color_title,
          content: this.$local.vn_admin.content_color,
        },
      ],
    }
  },

  computed: {
    formTitle() {
      return this.editedIndex === -1 ? 'Thêm dữ liệu' : 'Sửa dữ liệu'
    },
    dataColor() {
      return this.$store.state.admin.color.color
    },
    swatchStyle() {
      const { color, menu } = this
      return {
        backgroundColor: color,
        cursor: 'pointer',
        height: '30px',
        width: '30px',
        borderRadius: menu ? '50%' : '4px',
        transition: 'border-radius 200ms ease-in-out',
      }
    },
  },

  watch: {
    dialog(val) {
      val || this.close()
    },
    dialogDelete(val) {
      val || this.closeDelete()
    },
  },

  methods: {
    editItem(item) {
      this.editedIndex = this.desserts.indexOf(item)
      this.editedItem = Object.assign({}, item)
      this.dialog = true
    },

    deleteItem(item) {
      this.editedIndex = this.desserts.indexOf(item)
      this.editedItem = Object.assign({}, item)
      this.dialogDelete = true
    },

    deleteItemConfirm() {
      if (this.editedIndex > -1) {
        Object.assign(this.desserts[this.editedIndex], this.editedItem)
        this.$emit(
          'del',
          Object.assign(this.desserts[this.editedIndex], this.editedItem)
        )
      } else {
        // this.desserts.push(this.editedItem)
      }
      this.closeDelete()
    },

    close() {
      this.dialog = false
      this.$nextTick(() => {
        this.editedItem = Object.assign({}, this.defaultItem)
        this.editedIndex = -1
      })
    },

    closeDelete() {
      this.dialogDelete = false
      this.$nextTick(() => {
        this.editedItem = Object.assign({}, this.defaultItem)
        this.editedIndex = -1
      })
    },

    save() {
      if (this.editedIndex > -1) {
        Object.assign(this.desserts[this.editedIndex], this.editedItem)
      } else {
        const form = {
          name: this.name,
          code: this.color,
        }

        this.$store.dispatch('admin/color/addColor', form)
      }
      this.close()
    },
  },
}
</script>

<style></style>
