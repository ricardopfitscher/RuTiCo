import time
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.firefox.options import Options
import clipboard
import re

READY = True
COOKIES = True
LOGIN = True
SCROLL_PAUSE_TIME = 0.5
MAX_FILES = 10000
HEADLESS = False

def login_and_cookie(driver, url):
    global LOGIN
    global COOKIES
    global SCROLL_PAUSE_TIME
    #global scrolled
    driver.get(url)
    driver.implicitly_wait(1.0)
    if COOKIES:
        try:
            driver.find_element(By.XPATH,"//button[@class='consent-btn']").click()
            print("\tCookies accepted!")
            COOKIES = False
        except:
            pass

    if LOGIN:
        
        while True:
            # Scroll down to bottom
            # Wait to load page
            print("\tWaiting for login button and login form...")
            time.sleep(SCROLL_PAUSE_TIME)
            try:
                loginButton = driver.find_element(By.XPATH, "//*[@id='userProfileId']/a")
                loginButton.click()
                clickable = WebDriverWait(driver,5).until(EC.element_to_be_clickable((By.XPATH, "//span[@class='close']")))
                if clickable:
                    username = driver.find_element(By.ID,"luser")
                    password = driver.find_element(By.ID,"password")
                    username.send_keys("ricardo.pfitscher@gmail.com")
                    password.send_keys("ricardo123456")
                    driver.find_element(By.XPATH, "//button[@type='submit']").click()
                    print("\tLogged in!!")
                    LOGIN=False
                    time.sleep(5)
                    driver.implicitly_wait(5.0)
                    break
            except:
                pass

def extract_to_file(driver, url):
    global SCROLL_PAUSE_TIME
    driver.get(url) 
    print("Current page: %s"%(driver.title))
    message = "window.scrollTo(0, 0);"
    driver.execute_script(message)
    time.sleep(SCROLL_PAUSE_TIME)

    print("\tNow clicking on each Java code....")
    java_codes = driver.find_elements(By.XPATH,"//li[text()='Java']")
    if len(java_codes)==0:
        print("\tNo java code available")
        return(0)
    print("\tFound: ",len(java_codes))

    for java_code in java_codes:
        if(java_code.location['x']!=0 and java_code.location['y']!=0):
            java_code.click()

    message = "window.scrollTo(0, 0);"
    driver.execute_script(message)
    time.sleep(SCROLL_PAUSE_TIME)

    print("\tLooking for complexities... ")

    search_path = "//p[(contains(translate(., 'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'above')\
        or contains(translate(., 'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'complexity')\
        or contains(translate(., 'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'time'))\
        and (contains(.,'O(') or contains(.,'θ('))]"
    complexities = driver.find_elements(By.XPATH,search_path)
    n_complexities = len(complexities)

    if n_complexities == 0:
        print("\tNo complexity available")
        return(0)
    print("\tFound: ",n_complexities)
    message = "window.scrollTo(0, 0);"
    driver.execute_script(message)
    time.sleep(SCROLL_PAUSE_TIME)

    copy_codes = driver.find_elements(By.XPATH,"//div[@aria-hidden='false']//i[@id='copy-code-button']")
    
    validated_copy_codes = []
    for code in copy_codes:
        if(code.location['x']!=0 and code.location['y']!=0):
            validated_copy_codes.append(code)

    #free memory
    copy_codes.clear()

    print("\tCopyable codes:", len(validated_copy_codes))  
    
    cont=0 #number o codes registered
    for code in validated_copy_codes:
        #Looking for the nearest complexity --> MAIN IDEA
        nearest = complexities[0]
        for cxity in complexities:
            if(abs(cxity.location['y']-code.location['y'])< abs(nearest.location['y'] - code.location['y'])):
                nearest=cxity
        code.click()
        text = clipboard.paste()
        s=nearest.text.replace('θ','O')
        
        pos_time = s.find('time')
        pos_Time = s.find('Time')
        pos_nline= s.find('\n') 
        #print("NLINE:", pos_nline,pos_time,pos_Time)
        if pos_nline>0:
            if pos_time>=0:
                if pos_nline> pos_time:
                    s=s[pos_time:pos_nline]
            elif pos_Time>=0 and pos_nline> pos_Time :
                s=s[pos_Time:pos_nline]
        print("\tNearest text: ", s)
        f=s.rfind('O(')
        complexity=s[f+2:f+s[f:].find(')')] #TODO: SE TEM MAIS DE UMA NA FRASE, QUAL USAR? USANDO A ULTIMA
        filename="crawled_codes/"+ re.sub('[^a-zA-Z0-9 \n\.]', '', driver.title)+"-"+str(cont+1)+".java"
        text=("//%s\n//O(%s)\n%s"%(driver.current_url,complexity.lower(),text))
        with open(filename.replace(" ",""),'w') as f:
            f.write(text)
            f.close()
        cont+=1

    print("\t%d files saved!"%(cont))
    return(cont)

fireFoxOptions = Options()
fireFoxOptions.headless = HEADLESS
driver = webdriver.Firefox(options=fireFoxOptions)
#implicit wait
driver.implicitly_wait(1.0)
#maximize browser
driver.maximize_window()
#launch URL
start_page = "https://www.geeksforgeeks.org/fundamentals-of-algorithms/"
driver.get(start_page)
#identify element

login_and_cookie(driver,start_page)

print("Computing de list of pages")
ols = driver.find_elements(By.XPATH, "//div[@class='entry-content']//ol")
n_ols=len(ols)
pages=[]
for o in range(n_ols):
    xpath = "//div[@class='entry-content']//ol[%s]//a[@href]"%(str(o+1))
    hrefs =  driver.find_elements(By.XPATH,xpath )
    for href in hrefs:
        if  re.search('https',href.get_attribute("href")):
            pages.append(href.get_attribute("href"))

print("There are %d links on this page!"%(len(pages)))
print("Looking on each page")
if READY:
    files=0          
    for page in pages:  
        try:
            files+=extract_to_file(driver,page)
            print("Saved code files: ",files)
        except:
            print("#\n#Error on page\\#", page)
        if(files>=MAX_FILES):
            break 
else:
    page = "https://www.geeksforgeeks.org/bubble-sort/"
    extract_to_file(driver,page)


driver.quit()
