import { browser, by, element } from 'protractor';

export class AppPage {
  navigateTo() {
    return browser.get(browser.baseUrl) as Promise<any>;
  }

  getfindButton() {
    return element(by.id('findButton')).getText();
  }

  getInputDateButton() {
    return element(by.id('inputDate')).getText();
  }

  getReserveeButton() {
    return element(by.id('ReserveeBtn')).getText();
  }

}
