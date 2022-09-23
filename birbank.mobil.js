const { Builder, By, Key, until } = require('selenium-webdriver')
const assert = require('assert')
require('chromedriver');

describe('birbank', function() {
  this.timeout(60000)
  let driver
  let vars
  beforeEach(async function() {
    driver = await new Builder().forBrowser('chrome').build()
    vars = {}
  })
  afterEach(async function() {
    await driver.quit();
  })
  it('birbank', async function() {
    await driver.get("https://birbank.az/")
    await driver.sleep(3000)
    driver.manage().window().maximize();
    await driver.sleep(3000)
    await driver.findElement(By.linkText("Ödənişlər")).click()
    await driver.sleep(3000)
    await driver.findElement(By.linkText("Mobil")).click()
    await driver.sleep(3000)
    await driver.findElement(By.linkText("Bakcell")).click()
    await driver.sleep(3000)
    await driver.findElement(By.name("PHONE")).click()
    await driver.findElement(By.name("PHONE")).sendKeys("553923353")
    await driver.sleep(1000)
    await driver.switchTo().frame(0)
    await driver.findElement(By.css(".recaptcha-checkbox-border")).click()
    await driver.sleep(10000)
    await driver.switchTo().defaultContent()
    await driver.sleep(3000)
    await driver.findElement(By.css(".color-danger")).click()
    await driver.sleep(3000)
    await driver.findElement(By.name("value")).click()
    await driver.findElement(By.name("value")).sendKeys("1")
    await driver.findElement(By.name("number")).click()
    await driver.findElement(By.name("number")).sendKeys("1111111111111111")
    await driver.findElement(By.name("expiration")).sendKeys("11/22")
    await driver.findElement(By.name("cvc")).sendKeys("111")
    await driver.sleep(3000)
    let y = await driver.findElement(By.xpath("//button[@type='submit'][1]"))
    y.click()
    await driver.sleep(3000)
    await driver.close()
  })
})
