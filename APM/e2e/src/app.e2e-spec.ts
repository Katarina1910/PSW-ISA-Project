import { AppPage } from './app.po';
import {  logging } from 'protractor';
import { browser, by, element } from 'protractor';

describe('workspace-project App', () => {
  let page: AppPage;

  beforeEach(() => {
    page = new AppPage();
  });

it('should have find button on reserve room page', () => {

   browser.get('http://localhost:4200/#/HomepageCA/ReserveRooms');
   expect(page.getfindButton()).toEqual('Find');
  
});

it('should have reserve button on reverve room page', () => {

  browser.get('http://localhost:4200/#/HomepageCA/ReserveRooms');
  expect(page.getReserveeButton()).toEqual('Reserve');
});

it('should have input date on reverve room page', () => {

  browser.get('http://localhost:4200/#/HomepageCA/ReserveRooms');
  expect(page.getInputDateButton()).toBeDefined();
});

  afterEach(async () => {
    // Assert that there are no errors emitted from the browser
    const logs = await browser.manage().logs().get(logging.Type.BROWSER);
    expect(logs).not.toContain(jasmine.objectContaining({
      level: logging.Level.SEVERE,
    } as logging.Entry));
  });
});
