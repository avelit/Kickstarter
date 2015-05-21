# Kickstarter project

Visit our project at
http://kickstarter-gojava.herokuapp.com/

Short documentation.

The project envisaged preparation of the web-application having functionality similar to the Kickstarter web-site (may be accessed at https://www.kickstarter.com/). The application should provide access to a list of categories, and a number of projects in each category with the detailed description.

By accessing the main screen of the application guests will be able to see the welcome page containing photos and contact details of the project team.

All available categories may be accessed by following the "Discover" link in the top left corner of the header section.

Each category contains a number of projects. The list of all projects in a category my be accessed by clicking the category name. 

Each project name contains a link to the web page describing this particular project. Project details include name of the project, its description, identification number, and video attached to the project (if any). Link to video must be valid to avoid Error 500 in video frame.

Any user may read or write new comments to the project. There is also a blog post section, comments to which may be added only by the project creator.

Application supports Log In / Sign Up operations. After signing up new user receives an activation link to the email indicated during the registration. By following this link user may activate his account. After activating an account, user may be logged in using his credentials. There is also a "Remember me" mark that, if activated, would allow not entering login/password again upon future visits of the application.

Upon activating their account, all registered users may add new categories or projects using their profile page. Profile page may be accessed by clicking the user email in the top right corner (available only if user has successfully logged in). Profile page also contains links to all projects created by the user.

Application contains search system that allows searching categories or projects by their name (header section of the web-site).
