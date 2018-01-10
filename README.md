# moskito-home
Login service for MoSKito Alexa Skill

Using Spring framework and REST controllers

Perform login using this service. Should be used only inside Alexa Skill
/api/login?state=abc&client_id=alexa-skill&response_type=token&redirect_uri=https%3A%2F%2Fpitangui.amazon.com%2Fspa%2Fskill%2Faccount-linking-status.html%3FvendorId%3DAAAAAAAAAAAAAA

Get the app URL using access token from Alexa Skill 
/api/users/{accessToken}/app

Verify that the access token from Alexa Skill is still valid 
/api/token/{accessToken}/verify
