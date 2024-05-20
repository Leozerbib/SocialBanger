export default class RegisterDto {
    constructor(
      firstName = '',
      lastName = '',
      username = '',
      email = '',
      password = '',
      age = null,
      gender = '',
      interests = [],
      country = {}
    ) {
      this.firstName = firstName
      this.lastName = lastName
      this.username = username
      this.email = email
      this.password = password
      this.age = age
      this.gender = gender
      this.interests = interests
      this.country = country
    }
  }
  