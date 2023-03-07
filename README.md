# Hrms- Recruitment System

It is a Web Application implemented in Spring Boot where employers can publish their jobs, employees can see job postings and apply, and employees that works for application can manage operations within the application. I used PostgreSql as database. I did the database design and coding myself.

----------------------------------------------------------------------------------------------------------------------------------------------------------------------

IMPORTANT 1: Create fake services for authentication. For example, you don't really need to send mail.

IMPORTANT 2: Do not code outside of the requirements. This is software developer behavior against Project management and ALM (Application LifeCycle Management) rules.

Req 1: Job Seekers should be able to register in the system.

Accept conditions:

-> During registration, the user is asked for name, surname, tcno, year of birth, e-mail, password, password repetition information.
-> All fields are required. The user is informed.
-> Mernis verification is done and the system is registered. -> The user is notified if the validation is not valid. -> If there is a previously registered e-mail or tcno, the registration will not take place. The user is informed. -> Email verification is required for registration to take place.

Req 2: Employers should be able to register in the system.

Accept conditions:

-> During registration, the user is asked for company name, website, e-mail with the same domain as the website, phone, password, password repetition information. The purpose here is to prevent non-companies from joining the system. -> All fields are required. The user is informed. -> Company records are verified in two ways. Email verification is required for registration to occur. Approval from HRMS staff (our :)) is required. -> If there is a previously registered e-mail, the registration will not take place. The user is informed.

Req 3 : General job position names should be added to the system. For example Software Developer, Software Architect.

Accept conditions:

-> These positions cannot be repeated. The user is warned.

Req 4: Employers should be able to be listed. (Whole list only)

Req 5 : Job seekers should be able to be listed. (Whole list only)

Req 6 : Job positions should be listed. (Whole list only)
