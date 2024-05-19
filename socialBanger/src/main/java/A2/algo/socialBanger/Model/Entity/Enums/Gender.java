package A2.algo.socialBanger.Model.Entity.Enums;

public enum Gender {
	Male,
	Female,
	other;
	
	public static Gender StringToGender(String genderString) {
        switch (genderString) {
        	case "Male":
        		return 	Gender.Male;
        	case "Female":
        		return 	Gender.Female;
        	case "other":
        		return  Gender.other;
        }
        return null;
	}
}
