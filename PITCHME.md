---

##### Continuous Integration (CI) Testing 
##### to support Continuous Delivery (CD)

---
### Our goal:

* A CI framework of fast, automated feedback on the correctness of your application when there is a code change. 

* That sounds cool, but is it possible? 

* lets see

---

#### CI testing environment

![Test Environment](https://www.lucidchart.com/publicSegments/view/d50ed6d8-deb8-4d9a-be56-7adef4db8048/image.png)

---

#### Our goal:
* CI and CD framework that is manageable by the team not individuals. 
* Can we have one baseline framework which drive every other testing? 

![CI and CD framework](https://www.lucidchart.com/publicSegments/view/778a845b-0c5b-43ed-8d5f-d074a18094fa/image.png)

---

### What type of testing:
1. Functional testing
2. Non-functional testing 
3. BDD Acceptance testing 
4. Security testing

---
### Smoke tests: 
* Test main component first
* Capture show stoppers early
* Fail early but continue capturing more bugs
* Categorise tests so its lightweight
* Test categories as: Unit tests, component tests, system tests, functional tests, regression tests 
* A given test coexist of multiple categories 
 
--- 
### Functional tests:  
- Give confidence 
- Functionality of an application from the viewpoint of a client
- Driven by implemented stories or discovery of defects 
- Run slower tests after faster running tests: 
- Unit tests when code checked in and a selective functional tests 

---

### non-functional tests: 
- Monitor performance
- Establish a bench mark for system response time, latency, throughput, stress testing.
- Use bench mark to determine if performance degrading 
- Schedule periodic intervals to run non-functional tests     

---
### acceptance testing (BDD)

* To evaluate system meets the business requirements. 
* Assess whether it is acceptable for delivery.
* Domain driven-design to focus on the domain not technology 
* Uses business language which all parties can understand and contribute.  

---
### Security testing
* Establish what assets to protect
* Carry out a risk analysis and rank risks
* Identify threats and vulnerabilities of software application 
* Design tests to cover the top threats

---
### Security Testing continued
* Security test expires needs updating so stays valid tests
* Need integrate into CI to prevent reoccurring security problems   
* Injections 
* Broken authentication and Session Management
* Cross-Site Scripting (XSS) and more

[Windows of Vulnerability](https://www.owasp.org/index.php/File:WindowExposure.jpg)

---

### CD workflow driven by CI testing
 
 ![CD](https://blog.versionone.com/wp-content/uploads/sites/3/2015/03/CI_image2-e1426983470698.png)
 
 source: [versionone blog](https://blog.versionone.com/understanding-ci-in-cd/)
 
---

### CI and CD Challenges:
* Increased overhead in maintaining the CI systems
* Too much change 
* Too many failed builds
* Developers should be performing these activities

---

Questions ?

---

 

