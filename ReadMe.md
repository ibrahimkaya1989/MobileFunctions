
### Turkish Chars ASCII Values

// "os" : "ANDROID", "os" : "IOS"
```bash
CAPITAL          SMALL  
------------|-------------------
İ-->\u0130  | ı-->\u0131
Ş-->\u015E  | ş-->\u015F
Ü-->\u00DC  | ü-->\u00FC
Ç-->\u00C7  | ç-->\u00E7
Ğ-->\u011E  | ğ-->\u011F            
Ö-->\u00D6  | ö-->\u00F6
```

### Appium Commands

Appium 1.x Server
```bash
appium --version
appium -a 127.0.0.1 -p 4723
appium --allow-insecure=adb_shell --relaxed-security
```

Appium 2.x Server
```bash
appium --version
appium -pa /wd/hub --allow-insecure=adb_shell --relaxed-security
appium server -ka 800 --use-plugins=device-farm  -pa /wd/hub --plugin-device-farm-platform=android --allow-insecure=adb_shell --relaxed-security
```

### Allure Commands

```bash
allure --version
allure serve .\allure-results\
allure generate .\allure-results\ --clean -o allure-report
allure open allure-report

del .\allure-results\*
del .\allure-report\*
```