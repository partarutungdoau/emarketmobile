package com.example.user.aplikasipar33.Modul;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by User on 2/13/2020.
 */

public class ItemUser {

        @SerializedName("status")
        @Expose
        private Boolean status;
        @SerializedName("message")
        @Expose
        private String message;
        @SerializedName("id_user")
        @Expose
        private String idUser;
        @SerializedName("nama")
        @Expose
        private String nama;
        @SerializedName("alamat")
        @Expose
        private String alamat;
        @SerializedName("email")
        @Expose
        private String email;
        @SerializedName("no_telepon")
        @Expose
        private String noTelepon;
        @SerializedName("role")
        @Expose
        private String role;
        @SerializedName("username")
        @Expose
        private String username;
        @SerializedName("password")
        @Expose
        private String password;
    public static final String id_user = "ID_USER";

        public Boolean getStatus() {
            return status;
        }

        public void setStatus(Boolean status) {
            this.status = status;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getIdUser() {
            return idUser;
        }

        public void setIdUser(String idUser) {
            this.idUser = idUser;
        }

        public String getNama() {
            return nama;
        }

        public void setNama(String nama) {
            this.nama = nama;
        }

        public String getAlamat() {
            return alamat;
        }

        public void setAlamat(String alamat) {
            this.alamat = alamat;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getNoTelepon() {
            return noTelepon;
        }

        public void setNoTelepon(String noTelepon) {
            this.noTelepon = noTelepon;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

    }

