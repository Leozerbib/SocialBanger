import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Interest } from '../../../../model/Interest/interest.model';
import { Country } from '../../../../model/Country/country.model';
import { RegisterDto } from '../../../../model/User/register-dto.model';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html'
})
export class RegisterComponent implements OnInit {
  registerForm!: FormGroup;
  interests!: Interest[];
  countries!: Country[];

  constructor(private formBuilder: FormBuilder) { }

  ngOnInit() {
    this.registerForm = this.formBuilder.group({
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      username: ['', Validators.required],
      email: ['', Validators.required],
      password: ['', [Validators.required, Validators.minLength(6)]],
      age: ['', Validators.required],
      gender: ['', Validators.required],
      interests: ['', Validators.required],
      country: ['', Validators.required]
    });

    // Here you should fetch your interests and countries from your service
    // This is just a mockup
    this.interests = [
      
    ];

    this.countries = [

    ];
  }

  onSubmit() {
    if (this.registerForm.valid) {
      const registerDto = new RegisterDto(
        this.registerForm.value.firstName,
        this.registerForm.value.lastName,
        this.registerForm.value.username,
        this.registerForm.value.email,
        this.registerForm.value.password,
        this.registerForm.value.age,
        this.registerForm.value.gender,
        this.registerForm.value.interests,
        this.registerForm.value.country
      );

      // Here you should call your service to register the user
      console.log(registerDto);
    }
  }
}
