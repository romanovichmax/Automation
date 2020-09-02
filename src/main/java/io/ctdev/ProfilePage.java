package io.ctdev;

public class ProfilePage {
    String NameCss = "input[name='name']";
    String NameXpath = "//div[@role='dialog']//input[@name='name']";
    String NicknameCss = "input[name='login']";
    String NicknameXpath = "//div[@role='dialog']//input[@name='login']";
    String PhoneNumberCss = "input[name='phoneNumber']";
    String PhoneNumberXpath = "//div[@role='dialog']//input[@name='phoneNumber']";
    String PositionCss = "input[name='position']";
    String PositionXpath = "//div[@role='dialog']//input[@name='position']";
    String DepartmentCss = "input[name='department']";
    String DepartmentXpath = "//div[@role='dialog']//input[@name='department']";
    String CancelButtonCss = "div[class='editUserProfile_buttonsBox__3PsrQ'] button[type='button']";
    String CancelButtonXpath = "//button[@class='button_btn__2GBfK editUserProfile_cancelBtn__fnKLZ']";
    String SaveChangesButtonCss = "div[class='editUserProfile_buttonsBox__3PsrQ']button[type='submit']";
    String SaveChangesButtonXpath = "//button[@class='button_btn__2GBfK']";
    String UploadImageButtonCss = "div[role='dialog']  div[class='editUserProfile_dropZoneWrapper__28bs7'] input";
    String UploadImageButtonXpath = "//div[@class='ReactModalPortal'][contains(.,'My Profile')]//div[@class='editUserProfile_dropZoneWrapper__28bs7']//input";
    String closeButtonCss = "div[role='dialog'] > button";
    String closeButtonXpath = "//div[@class='ReactModalPortal'][contains(.,'My Profile')]//button[@class='react-modal-close-btn']";
}