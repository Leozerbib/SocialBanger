<template>
    <div class="login-box">
      <h2>Register</h2>
      <form @submit.prevent="register">
        <div class="user-box">
          <label>First Name</label>
          <input type="text" id="firstName" v-model="firstName" required>
        </div>
        <div class="user-box">
          <label>Last Name</label>
          <input type="text" id="lastName" v-model="lastName" required>
        </div>
        <div class="user-box">
          <label>Username</label>
          <input type="text" id="username" v-model="username" required>
        </div>
        <div class="user-box">
          <label>Email</label>
          <input type="email" id="email" v-model="email" required>
        </div>
        <div class="user-box">
          <label>Password</label>
          <input type="password" id="password" v-model="password" required>
        </div>
        <div class="user-box">
          <label>Confirm Password</label>
          <input type="password" id="passwordVerify" v-model="passwordVerify" required>
        </div>
        <div class="user-box">
          <label>Age</label>
          <input type="number" id="age" v-model.number="age" required>
        </div>
        <div class="user-box">
          <label>Gender</label>
          <q-select v-model="gender" :options="['Male', 'Female', 'Other']" />
        </div>
        <div class="user-box">
          <label>Country</label>
          <q-select v-model="country" :options="countries" option-label="country" option-value="id" @input="onCountryChange">
        </q-select>
        </div>
        <div class="user-box">
          <label>Interests</label>
          <q-select
            filled
            v-model="selectedInterests"
            multiple
            :options="interests"
            option-label="subcategory"
            option-value="id"
            counter
            max-values="5"
            hint="Max 5 selections"
            style="width: 250px"
          />
        </div>
        <div class="user-box">
          <button type="submit" :disabled="isFormInvalid">Register</button>
        </div>
      </form>
    </div>
  </template>
  
  
  <script>
import { ref, onMounted, computed } from 'vue'
import axios from 'axios'
import Country from '../../api/Model/country/country'
import RegisterDto from '../../api/Model/User/registerDto'
import Interest from '../../api/Model/interests/interests'
import { useQuasar } from 'quasar'

export default {
  setup() {
    const firstName = ref('')
    const lastName = ref('')
    const username = ref('')
    const email = ref('')
    const password = ref('')
    const passwordVerify = ref('')
    const age = ref(null)
    const gender = ref('')
    const countries = ref([])
    const interests = ref([])
    const country = ref(null)
    const selectedInterests = ref([])

    onMounted(() => {
      // Fetch the list of countries from the API
      axios.get('http://localhost:8090/api/v1/country/getAll')
        .then(response => {
          countries.value = response.data.data.map(countryData => new Country(
            countryData.id,
            countryData.code,
            countryData.country,
            countryData.flag_image_url
          ))
        })
        .catch(error => {
          console.error(error)
        })

      // Fetch the list of interests from the API
      axios.get('http://localhost:8090/api/v1/interest/getAll')
        .then(response => {
          interests.value = response.data.data.map(interestData => new Interest(
            interestData.id,
            interestData.category,
            interestData.subcategory
          ))
        })
        .catch(error => {
          console.error(error)
        })
    })

    const isFormInvalid = computed(() => {
      return password.value !== passwordVerify.value ||
             !firstName.value ||
             !lastName.value ||
             !username.value ||
             !email.value ||
             !age.value ||
             !gender.value ||
             !country.value ||
             selectedInterests.value.length === 0
    })

    const register = () => {
      // Prepare the request payload
      const dto = new RegisterDto(
        firstName.value,
        lastName.value,
        username.value,
        email.value,
        password.value,
        age.value,
        gender.value,
        selectedInterests.value,
        country.value
      )

      // Send the request to the API
      axios.post('http://localhost:8090/api/v1/user/register', dto)
        .then(response => {
          // Handle the response from the API
          console.log(response.data)
        })
        .catch(error => {
          // Handle the error from the API
          console.error(error)
        })
    }

    const onCountryChange = (selectedCountry) => {
      country.value = selectedCountry
    }

    return {
      firstName,
      lastName,
      username,
      email,
      password,
      passwordVerify,
      age,
      gender,
      countries,
      interests,
      country,
      selectedInterests,
      isFormInvalid,
      register,
      onCountryChange
    }
  }
}
</script>

  
     
<style scoped>
html {
    height: 100%;
}

.login-box {
    position: absolute;
    top: 50%;
    left: 50%;
    width: 400px;
    padding: 40px;
    transform: translate(-50%, -50%);
    background: rgba(0,0,0,.5);
    box-sizing: border-box;
    box-shadow: 0 15px 25px rgba(0,0,0,.6);
    border-radius: 10px;
}

.login-box h2 {
    margin: 0 0 30px;
    padding: 0;
    color: #fff;
    text-align: center;
}

.login-box .user-box {
    position: relative;
}

.login-box .user-box input {
    width: 100%;
    padding: 10px 0;
    font-size: 16px;
    color: #fff;
    margin-bottom: 10px;
    border: none;
    border-bottom: 1px solid #fff;
    outline: none;
    background: transparent;
}
.login-box .user-box label {
    
    top:0;
    left: 0;
    padding: 10px 0;
    font-size: 16px;
    color: #fff;
    transition: .5s;
}

.login-box .user-box input:focus ~ label,
.login-box .user-box input:valid ~ label {
    top: -20px;
    left: 0;
    color: #03e9f4;
    font-size: 12px;
}

.login-box form a {
    position: relative;
    display: inline-block;
    padding: 10px 20px;
    color: #03e9f4;
    font-size: 16px;
    text-decoration: none;
    text-transform: uppercase;
    overflow: hidden;
    transition: .5s;
    margin-top: 40px;
    letter-spacing: 4px
}

.user-box label {
    -webkit-appearance: none;
    -moz-appearance: none;
    background-color: transparent;
    border: none;
    border-radius: 0;
    padding: 10px 0;
    font-size: 16px;
    color: #ff0000;
    margin-bottom: 30px;
    outline: none;
    cursor: pointer;
    width: 100%;
    height: 100%;
}

.user-box label::-ms-expand {
display: none;
}

.user-box label {
top: -20px;
left: 0;
color: #03e9f4;
font-size: 12px;
}

.user-box label option {
padding: 5px;
font-size: 14px;
color: #ee0000;
background-color: #fff;
}

.user-box label option:hover {
background-color: #f5f5f5;
}

</style>
  