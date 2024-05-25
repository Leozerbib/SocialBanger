import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, FormArray, FormControl } from '@angular/forms';
import { InterestService } from '../../../../service/Interest/interest.service'; // Adjust the path accordingly
import { CountryService } from '../../../../service/Country/country.service'; // Adjust the path accordingly
import { Interest } from '../../../../model/Interest/interest.model';
import { Country } from '../../../../model/Country/country.model';
import { RegisterDto } from '../../../../model/User/register-dto.model';
import { LoginDto } from '../../../../model/User/login-dto.model';
import { AccountService } from '../../../../service/User/uer-service.service'; // Adjust the path accordingly
import { AlertService } from '../../../../service/util/alert.service'; // Adjust the path accordingly
import { Router, ActivatedRoute } from '@angular/router';
import { first } from 'rxjs/operators';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {
  registerForm!: FormGroup;
  interests: Interest[] = [];
  countries: Country[] = [];
  interest: Interest[] = [];
  errorMessage: string = '';
  loading: boolean = false;
  touch: boolean = false;
  interet : Interest = new Interest(0, '', '');
  country : Country = new Country(0, '','','');

  constructor(
    private formBuilder: FormBuilder,
    private interestService: InterestService,
    private countryService: CountryService,
    private accountService: AccountService,
    private alertService: AlertService,
    private router: Router,
    private route: ActivatedRoute,

  ) { }

  ngOnInit() {
    this.registerForm = this.formBuilder.group({
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      username: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(6)]],
      age: ['', Validators.required],
      gender: ['', Validators.required],
      interests: this.formBuilder.array([Interest], [Validators.required, Validators.maxLength(5)]),
      country: [Country, Validators.required]
    });

    this.loadInterests();
    this.loadCountries();
  }

  get interestsFormArray(): FormArray {
    return this.registerForm.get('interests') as FormArray;
  }

  loadInterests() {
    this.interestService.getAllInterests().subscribe({
      next: (response) => {
        if (response.success) {
          for (let i = 0; i < response.data.length; i++) {
            const intereste = new Interest(response.data[i].id, response.data[i].category, response.data[i].subcategory);
            this.interests.push(intereste);
          }
        } else {
          this.errorMessage = response.message;
        }
      },
      error: (err) => {
        this.errorMessage = 'An error occurred while fetching interests';
        console.error(err);
      }
    });
  }

  loadCountries() {
    this.countryService.getAllCountries().subscribe({
      next: (response) => {
        if (response.success) {
          for (let i = 0; i < response.data.length; i++) {
            const countrys = new Country(response.data[i].id, response.data[i].code, response.data[i].country, response.data[i].flag_image_url);
            this.countries.push(countrys);
          }
        } else {
          this.errorMessage = response.message;
        }
      },
      error: (err) => {
        this.errorMessage = 'An error occurred while fetching countries';
        console.error(err);
      }
    });
  }

  onInterestChange(event: any) {
    const interests: FormArray = this.interestsFormArray;
    console.log(event.target.value);
    if (event.target.checked) {
      if (interests.length < 5) {
        interests.push(new FormControl(event.target.value));
      } else {
        event.target.checked = false;
      }
    } else {
      const index = interests.controls.findIndex(x => x.value === event.target.value);
      interests.removeAt(index);
    }
  }

  ontouch() {
    if (this.touch) {
      this.touch = false;
    }
    else {
      this.touch = true;
    }
    console.log(this.touch);
  }

  onSubmit() {
    if (this.registerForm.valid) {
      this.registerForm.value.interests.forEach((element: number) => {
        console.log("----------" + element);
        console.log(this.interests);
        this.interet = this.interests.find((i) => i.id = element) as Interest;
        console.log(this.interet);
        this.interest.push(this.interet);
      });
      this.country = this.countries.find((c) => c.id = this.registerForm.value.country) as Country;
      console.log(this.registerForm.value.country);
      console.log(this.registerForm.value.lastName);
      console.log(this.country);
      const registerDto = new RegisterDto(
        this.registerForm.value.firstName,
        this.registerForm.value.lastName,
        this.registerForm.value.username,
        this.registerForm.value.email,
        this.registerForm.value.password,
        this.registerForm.value.age,
        this.registerForm.value.gender,
        this.interest as Interest[],
        this.country as Country
      );

      // Here you should call your service to register the user
      console.log(registerDto);
      this.accountService.register(registerDto)
            .pipe(first())
            .subscribe({
                next: () => {
                    // get return url from query parameters or default to home page
                    const returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
                    this.router.navigateByUrl(returnUrl);
                },
                error: error => {
                    this.alertService.error(error);
                    this.loading = false;
                }
            });
    }
    }

  }
