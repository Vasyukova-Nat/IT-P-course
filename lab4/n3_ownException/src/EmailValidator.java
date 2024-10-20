public class EmailValidator {

    private static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";

    public void validateEmail(String email) throws CustomEmailFormatException {
        if (!email.matches(EMAIL_REGEX)) {
            throw new CustomEmailFormatException("Invalid email format: " + email);
        }
    }
}