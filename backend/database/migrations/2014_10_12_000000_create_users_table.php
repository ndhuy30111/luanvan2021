<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

class CreateUsersTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('users', function (Blueprint $table) {
            $table->integer('id',true);
            $table->string('name',30);
            $table->string('email',50)->unique();
            $table->integer('numberphone')->size(11)->nullable();
            $table->string('address', 50)->nullable();
            $table->timestamp('email_verified_at')->nullable();
            $table->string('password',100);
            $table->tinyInteger('status')->size('1')->default('1');
            $table->rememberToken();
            $table->timestamps();
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('users');
    }
}
