package com.navi.web_api_db_lektion_5.__uppgifter.controller

import com.navi.web_api_db_lektion_5.__uppgifter.CustomUserRepository
import com.navi.web_api_db_lektion_5.__uppgifter.model.CustomUser
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class CustomUserController(
   private val customUserRepository: CustomUserRepository
) {


    @PostMapping("/user")
    fun postNewUser(@RequestBody user: CustomUser): CustomUser {

        return customUserRepository.save(user)
    }


    @GetMapping("/users")
    fun getAllUsers(): List<CustomUser> {

      return customUserRepository.findAll()
    }

    @GetMapping("/user")
    fun getUserByID(@RequestParam("id") id: Long): ResponseEntity<CustomUser> {

        val existingUser = customUserRepository.findById(id)

        if(existingUser.isPresent) {
            val foundUser = existingUser.get()
            return  ResponseEntity.status(200).body(foundUser)
        } else {
           return ResponseEntity.notFound().build()
        }

    }

    @DeleteMapping("/user")
    fun deleteUserByID(@RequestParam("delete") delete: Long) {

        customUserRepository.deleteById(delete)

    }


    @PutMapping("/user")
    fun updateUser(@PathVariable id: Long, @RequestBody updatedUser: CustomUser): ResponseEntity<CustomUser> {
        val existingUserOptional = customUserRepository.findById(id)

        return if (existingUserOptional.isPresent) {
            val existingUser = existingUserOptional.get()

            // Update the values of the existing user
            val userToUpdate = existingUser.copy(
                name = updatedUser.name,
                password = updatedUser.password
            )

            // Save the updated user
            ResponseEntity.ok(customUserRepository.save(userToUpdate))
        } else {
            ResponseEntity.notFound().build()
        }

    }
}