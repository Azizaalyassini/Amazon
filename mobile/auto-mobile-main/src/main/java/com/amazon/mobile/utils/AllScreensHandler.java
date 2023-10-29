package com.amazon.mobile.utils;

import com.amazon.mobile.screens.login.*;
import com.amazon.mobile.controllers.ThreadLocalDriver;
import com.cr2.mobile.screens.agent.delegation.CustomerDetailsScreen;
import com.cr2.mobile.screens.agent.delegation.CustomerDetailsScreenLocators;
import com.cr2.mobile.screens.agent.delegation.DelegationScreen;
import com.cr2.mobile.screens.agent.delegation.DelegationScreenLocators;
import com.cr2.mobile.screens.login.*;
import com.cr2.mobile.screens.shared.Notifications.NotificationsScreen;
import com.cr2.mobile.screens.shared.Notifications.NotificationsScreenLocators;
import com.cr2.mobile.screens.shared.cards.*;
import com.cr2.mobile.screens.shared.dashboard.MainDashboardScreen;
import com.cr2.mobile.screens.shared.dashboard.MainDashboardScreenLocators;
import com.cr2.mobile.screens.shared.login.*;
import com.cr2.mobile.screens.shared.messages.*;
import com.cr2.mobile.screens.shared.moreOptions.ExchangeRateScreen;
import com.cr2.mobile.screens.shared.moreOptions.ExchangeRateScreenLocators;
import com.cr2.mobile.screens.shared.myProfile.MyProfileScreen;
import com.cr2.mobile.screens.shared.myProfile.MyProfileScreenLocators;
import com.cr2.mobile.screens.shared.paymentCenter.*;
import com.cr2.mobile.screens.shared.profileMenu.ProfileMenuScreen;
import com.cr2.mobile.screens.shared.profileMenu.ProfileMenuScreenLocators;
import com.cr2.mobile.screens.shared.settings.*;
import com.cr2.mobile.screens.shared.sharedScreenComponents.*;
import com.cr2.mobile.screens.user.allAccounts.*;
import com.cr2.mobile.screens.user.campains.CampaignsScreen;
import com.cr2.mobile.screens.user.campains.CampaignsScreenLocators;
import com.cr2.mobile.screens.user.digitalWalletAd.DigitalWalletAdScreen;
import com.cr2.mobile.screens.user.digitalWalletAd.DigitalWalletAdScreenLocators;
import com.cr2.mobile.screens.user.kyc.KYCScreen;
import com.cr2.mobile.screens.user.kyc.KYCScreenLocators;
import com.cr2.mobile.screens.user.loggedInMore.*;
import com.cr2.mobile.screens.user.login.OpenDWScreen;
import com.cr2.mobile.screens.user.login.OpenDWScreenLocators;
import com.cr2.mobile.screens.user.login.gettOnlineBankAccess.*;
import com.cr2.mobile.screens.user.mainDashboard.*;
import com.cr2.mobile.screens.user.paymentCentre.*;
import com.cr2.mobile.screens.user.preLogin.*;
import com.cr2.mobile.screens.user.settings.*;
import com.cr2.mobile.screens.user.settings.approvalRules.*;
import com.cr2.mobile.screens.user.widgets.*;


public class AllScreensHandler {

    public ActionScreen getActionScreen() {
        return new ActionScreen(ThreadLocalDriver.getTLDriver(), new ActionScreenLocators());
    }

    public DigitalWalletAdScreen getDigitalWalletAdScreen() {
        return new DigitalWalletAdScreen(ThreadLocalDriver.getTLDriver(), new DigitalWalletAdScreenLocators());
    }

    public LoginScreen getLoginScreen() {
        return new LoginScreen(ThreadLocalDriver.getTLDriver(), new LoginScreenLocators());
    }

    public PreLoginContactUsScreen getContactUsScreen() {
        return new PreLoginContactUsScreen(ThreadLocalDriver.getTLDriver(), new PreLoginContactUsScreenLocators());
    }

    public MainDashboardScreen getMainDashboardScreen() {
        return new MainDashboardScreen(ThreadLocalDriver.getTLDriver(), new MainDashboardScreenLocators());
    }

    public ProfileMenuScreen getProfileMenuScreen() {
        return new ProfileMenuScreen(ThreadLocalDriver.getTLDriver(), new ProfileMenuScreenLocators());
    }

    public PreLoginMoreScreen getPreLoginMoreScreen() {
        return new PreLoginMoreScreen(ThreadLocalDriver.getTLDriver(), new PreLoginMoreScreenLocators());
    }

    public MapScreen getMapScreen() {
        return new MapScreen(ThreadLocalDriver.getTLDriver(), new MapScreenLocators());
    }

    public FAQScreen getFAQScreen() {
        return new FAQScreen(ThreadLocalDriver.getTLDriver(), new FAQScreenLocators());
    }

    public CardsScreen getCardsScreen() {
        return new CardsScreen(ThreadLocalDriver.getTLDriver(), new CardsScreenLocators());
    }

    public ConfigurationScreen getConfigurationScreen() {
        return new ConfigurationScreen(ThreadLocalDriver.getTLDriver(), new ConfigurationScreenLocators());
    }

    public CurrencyCalculatorScreen getCurrencyCalculatorScreen() {
        return new CurrencyCalculatorScreen(ThreadLocalDriver.getTLDriver(), new CurrencyCalculatorScreenLocators());
    }

    public FeesAndChargesScreen getFeesAndChargesScreen() {
        return new FeesAndChargesScreen(ThreadLocalDriver.getTLDriver(), new FeesAndChargesScreenLocators());
    }

    public BankNewsScreen getBankNewsScreen() {
        return new BankNewsScreen(ThreadLocalDriver.getTLDriver(), new BankNewsScreenLocators());
    }

    public PrivacyPolicyScreen getPrivacyPolicyScreen() {
        return new PrivacyPolicyScreen(ThreadLocalDriver.getTLDriver(), new PrivacyPolicyScreenLocators());
    }

    public TermsAndConditionsScreen getTermsAndConditionsScreen() {
        return new TermsAndConditionsScreen(ThreadLocalDriver.getTLDriver(), new TermsAndConditionsScreenLocators());
    }

    public LoggedInMoreScreen getLoggedInMoreScreen() {
        return new LoggedInMoreScreen(ThreadLocalDriver.getTLDriver(), new LoggedInMoreScreenLocators());
    }

    public ATMCashScreen getATMCashScreen() {
        return new ATMCashScreen(ThreadLocalDriver.getTLDriver(), new ATMCashScreenLocators());
    }

    public EmergencyCashScreen getEmergencyCashScreen() {
        return new EmergencyCashScreen(ThreadLocalDriver.getTLDriver(), new EmergencyCashScreenLocators());
    }

    public TransactionConfirmationScreen getTransactionConfirmationScreen() {
        return new TransactionConfirmationScreen(ThreadLocalDriver.getTLDriver(), new TransactionConfirmationScreenLocators());
    }

    public TransactionSuccessScreen getTransactionSuccessScreen() {
        return new TransactionSuccessScreen(ThreadLocalDriver.getTLDriver(), new TransactionSuccessScreenLocators());
    }

    public NavigationScreen getNavigationScreen() {
        return new NavigationScreen(ThreadLocalDriver.getTLDriver(), new NavigationScreenLocators());
    }

    public PaymentsScreen getPaymentScreen() {
        return new PaymentsScreen(ThreadLocalDriver.getTLDriver(), new PaymentsScreenLocators());
    }

    public ErrorScreen getErrorScreen() {
        return new ErrorScreen(ThreadLocalDriver.getTLDriver(), new ErrorScreenLocators());
    }

    public AlertScreen getAlertScreen() {
        return new AlertScreen(ThreadLocalDriver.getTLDriver(), new AlertScreenLocators());
    }

    public AccountTransfersScreen getAccountTransfersScreen() {
        return new AccountTransfersScreen(ThreadLocalDriver.getTLDriver(), new AccountTransfersScreenLocators());
    }

    public PaymentCentreScreen getPaymentCentreScreen() {
        return new PaymentCentreScreen(ThreadLocalDriver.getTLDriver(), new PaymentCentreScreenLocators());
    }

    public DateScreen getDateScreen() {
        return new DateScreen(ThreadLocalDriver.getTLDriver(), new DateScreenLocators());
    }

    public TokensScreen getTokenScreen() {
        return new TokensScreen(ThreadLocalDriver.getTLDriver(), new TokensScreenLocators());
    }

    public AccountsScreen getAccountsScreen() {
        return new AccountsScreen(ThreadLocalDriver.getTLDriver(), new AccountsScreenLocators());
    }

    public FABScreen getFABScreen() {
        return new FABScreen(ThreadLocalDriver.getTLDriver(), new FABScreenLocators());
    }

    public AccountDetailsScreen getAccountDetailScreen() {
        return new AccountDetailsScreen(ThreadLocalDriver.getTLDriver(), new AccountDetailsScreenLocators());
    }

    public AccountActivityScreen getAccountActivityScreen() {
        return new AccountActivityScreen(ThreadLocalDriver.getTLDriver(), new AccountActivityScreenLocators());
    }

    public TransferMoneyScreen getTransferMoneyScreen() {
        return new TransferMoneyScreen(ThreadLocalDriver.getTLDriver(), new TransferMoneyScreenLocators());
    }

    public KYCScreen getKYCScreen() {
        return new KYCScreen(ThreadLocalDriver.getTLDriver(), new KYCScreenLocators());
    }

    public SettingMenuScreen getSettingMenuScreen() {
        return new SettingMenuScreen(ThreadLocalDriver.getTLDriver(), new SettingMenuScreenLocators());
    }

    public NewPaymentsScreen getNewPaymentScreen() {
        return new NewPaymentsScreen(ThreadLocalDriver.getTLDriver(), new NewPaymentsScreenLocators());
    }

    public MyTemplatesScreen getMyTemplatesScreen() {
        return new MyTemplatesScreen(ThreadLocalDriver.getTLDriver(), new MyTemplatesScreenLocators());
    }

    public ImageUploadScreen getImageUploadScreen() {
        return new ImageUploadScreen(ThreadLocalDriver.getTLDriver(), new ImageUploadScreenLocators());
    }

    public BillPaymentsScreen getBillPaymentsScreen() {
        return new BillPaymentsScreen(ThreadLocalDriver.getTLDriver(), new BillPaymentsScreenLocators());
    }

    public ScheduledTransactionsScreen getScheduledTransactionsScreen() {
        return new ScheduledTransactionsScreen(ThreadLocalDriver.getTLDriver(), new ScheduledTransactionsScreenLocators());
    }

    public WalletScreen getWalletScreen() {
        return new WalletScreen(ThreadLocalDriver.getTLDriver(), new WalletScreenLocators());
    }

    public WalletSettingsScreen getWalletSettingsScreen() {
        return new WalletSettingsScreen(ThreadLocalDriver.getTLDriver(), new WalletSettingsScreenLocators());
    }

    public CardsViewScreen getCardsViewScreen() {
        return new CardsViewScreen(ThreadLocalDriver.getTLDriver(), new CardsViewScreenLocators());
    }

    public ApprovalRulesScreen getApprovalRulesScreen() {
        return new ApprovalRulesScreen(ThreadLocalDriver.getTLDriver(), new ApprovalRulesScreenLocators());
    }

    public ForgotUserNameScreen getForgotUserNameScreen() {
        return new ForgotUserNameScreen(ThreadLocalDriver.getTLDriver(), new ForgotUserNameScreenLocators());
    }

    public ForgotPasswordScreen getForgotPasswordScreen() {
        return new ForgotPasswordScreen(ThreadLocalDriver.getTLDriver(), new ForgotPasswordScreenLocators());
    }

    public QRCodesScreen getQRCodesScreen() {
        return new QRCodesScreen(ThreadLocalDriver.getTLDriver(), new QRCodesScreenLocators());
    }

    public QRCodesPCTransfersScreen getQRCodesPCTransfersScreen() {
        return new QRCodesPCTransfersScreen(ThreadLocalDriver.getTLDriver(), new QRCodesPCTransfersScreenLocators());
    }

    public OpenDWScreen getOpenDWScreen() {
        return new OpenDWScreen(ThreadLocalDriver.getTLDriver(), new OpenDWScreenLocators());
    }

    public MoneyVoucherScreen getMoneyVoucherScreen() {
        return new MoneyVoucherScreen(ThreadLocalDriver.getTLDriver(), new MoneyVoucherScreenLocators());
    }


    public RequestsScreen getRequestsScreen() {
        return new RequestsScreen(ThreadLocalDriver.getTLDriver(), new RequestsScreenLocators());
    }

    public RequestDetailsScreen getRequestDetailsScreen() {
        return new RequestDetailsScreen(ThreadLocalDriver.getTLDriver(), new RequestDetailsScreenLocators());
    }

    public FilterRequestsScreen getFilterScreen() {
        return new FilterRequestsScreen(ThreadLocalDriver.getTLDriver(), new FilterRequestsScreenLocators());
    }

    public ModalScreen getModalScreen() {
        return new ModalScreen(ThreadLocalDriver.getTLDriver(), new ModalScreenLocators());
    }

    public WidgetScreen getWidgetScreen() {
        return new WidgetScreen(ThreadLocalDriver.getTLDriver(), new WidgetScreenLocators());
    }

    public PersonalBankerScreen getPersonalBankerScreen() {
        return new PersonalBankerScreen(ThreadLocalDriver.getTLDriver(), new PersonalBankerScreenLocators());
    }

    public ActivityCalendarScreen getActivityCalendarScreen() {
        return new ActivityCalendarScreen(ThreadLocalDriver.getTLDriver(), new ActivityCalendarScreenLocators());
    }

    public OnlineSupportScreen getOnlineSupportScreen() {
        return new OnlineSupportScreen(ThreadLocalDriver.getTLDriver(), new OnlineSupportScreenLocators());
    }

    public OverdraftScreen getOverdraftScreen() {
        return new OverdraftScreen(ThreadLocalDriver.getTLDriver(), new OverdraftScreenLocators());
    }

    public RulesScreen getRulesScreen() {
        return new RulesScreen(ThreadLocalDriver.getTLDriver(), new RulesScreenLocators());
    }

    public TransactionRuleScreen getTransactionRuleScreen() {
        return new TransactionRuleScreen(ThreadLocalDriver.getTLDriver(), new TransactionRuleLocators());
    }

    public UserGroupsScreen getUserGroupsScreen() {
        return new UserGroupsScreen(ThreadLocalDriver.getTLDriver(), new UserGroupsScreenLocators());
    }

    public DefaultLocaleScreen getDefaultLocaleScreen() {
        return new DefaultLocaleScreen(ThreadLocalDriver.getTLDriver(), new DefaultLocaleScreenLocators());
    }

    public DefaultCurrencyScreen getDefaultCurrencyScreen() {
        return new DefaultCurrencyScreen(ThreadLocalDriver.getTLDriver(), new DefaultCurrencyScreenLocators());
    }


    public LoginAndPasswordScreen getLoginAndPasswordScreen() {
        return new LoginAndPasswordScreen(ThreadLocalDriver.getTLDriver(), new LoginAndPasswordScreenLocators());
    }

    public p2pSettingScreen getP2pSettingScreen() {
        return new p2pSettingScreen(ThreadLocalDriver.getTLDriver(), new p2pSettingScreenLocators());
    }

    public MyProfileScreen getMyProfileScreen() {
        return new MyProfileScreen(ThreadLocalDriver.getTLDriver(), new MyProfileScreenLocators());
    }

    public CardControlsScreen getCardControlsScreen() {
        return new CardControlsScreen(ThreadLocalDriver.getTLDriver(), new CardControlsScreenLocators());
    }


    public TransactionsScreen getTransactionsScreen() {
        return new TransactionsScreen(ThreadLocalDriver.getTLDriver(), new TransactionsScreenLocators());
    }

    public NotificationsScreen getNotificationsScreen() {
        return new NotificationsScreen(ThreadLocalDriver.getTLDriver(), new NotificationsScreenLocators());
    }

    public DefaultAccountScreen getDefaultAccountScreen() {
        return new DefaultAccountScreen(ThreadLocalDriver.getTLDriver(), new DefaultAccountScreenLocators());
    }

    public MessagesScreen getMessagesScreen() {
        return new MessagesScreen(ThreadLocalDriver.getTLDriver(), new MessagesScreenLocators());
    }

    public ComposeMessageScreen getComposeMessageScreen() {
        return new ComposeMessageScreen(ThreadLocalDriver.getTLDriver(), new ComposeMessageScreenLocators());
    }

    public FilterTransactionsScreen getFilterTransactionsScreen() {
        return new FilterTransactionsScreen(ThreadLocalDriver.getTLDriver(), new FilterTransactionsScreenLocators());
    }

    public DelegationScreen getDelegationScreen() {
        return new DelegationScreen(ThreadLocalDriver.getTLDriver(), new DelegationScreenLocators());
    }

    public CustomerDetailsScreen getCustomerDetailsScreen() {
        return new CustomerDetailsScreen(ThreadLocalDriver.getTLDriver(), new CustomerDetailsScreenLocators());
    }

    public ChequesScreen getChequesScreen() {
        return new ChequesScreen(ThreadLocalDriver.getTLDriver(), new ChequesScreenLocators());
    }

    public ShowHidePasswordScreen getShowHidePasswordScreen() {
        return new ShowHidePasswordScreen(ThreadLocalDriver.getTLDriver(), new ShowHidePasswordScreenLocators());
    }

    public GetOnlineBankAccessScreen getGetOnlineBankAccessScreen() {
        return new GetOnlineBankAccessScreen(ThreadLocalDriver.getTLDriver(), new GetOnlineBankAccessScreenLocators());
    }

    public YourBankCardScreen getYourBankCardScreen() {
        return new YourBankCardScreen(ThreadLocalDriver.getTLDriver(), new YourBankCardScreenLocators());
    }

    public YourBankAccountScreen getYourBankAccountScreen() {
        return new YourBankAccountScreen(ThreadLocalDriver.getTLDriver(), new YourBankAccountScreenLocators());
    }

    public PassportScreen getPassportScreen() {
        return new PassportScreen(ThreadLocalDriver.getTLDriver(), new PassportScreenLocators());
    }

    public OpenAccountScreen getOpenAccountScreen() {
        return new OpenAccountScreen(ThreadLocalDriver.getTLDriver(), new OpenAccountScreenLocators());
    }

    public CampaignsScreen getCampaignsScreen() {
        return new CampaignsScreen(ThreadLocalDriver.getTLDriver(), new CampaignsScreenLocators());
    }

    public CopyrightScreen getCopyrightScreen() {
        return new CopyrightScreen(ThreadLocalDriver.getTLDriver(), new CopyrightScreenLocators());
    }

    public ExchangeRateScreen getExchangeRateScreen() {
        return new ExchangeRateScreen(ThreadLocalDriver.getTLDriver(), new ExchangeRateScreenLocators());
    }

    public FinanceNewsScreen getFinanceNewsScreen() {
        return new FinanceNewsScreen(ThreadLocalDriver.getTLDriver(), new FinanceNewsScreenLocators());
    }

    public DepositCalculatorScreen getDepositCalculatorScreen() {
        return new DepositCalculatorScreen(ThreadLocalDriver.getTLDriver(), new DepositCalculatorScreenLocators());
    }

    public ManageBalancesScreen getManageBalancesScreen() {
        return new ManageBalancesScreen(ThreadLocalDriver.getTLDriver(), new ManageBalancesScreenLocators());
    }

    public TopUpScreen getTopUpScreen() {
        return new TopUpScreen(ThreadLocalDriver.getTLDriver(), new TopUpScreenLocators());
    }

    public OtherBankAccountScreen getOtherBankAccountScreen() {
        return new OtherBankAccountScreen(ThreadLocalDriver.getTLDriver(), new OtherBankAccountScreenLocators());
    }

    public RemittancePDFScreen getRemittancePDFScreen() {
        return new RemittancePDFScreen(ThreadLocalDriver.getTLDriver(), new RemittancePDFScreenLocators());
    }

    public QuickServicesScreen getQuickServicesScreen() {
        return new QuickServicesScreen(ThreadLocalDriver.getTLDriver(), new QuickServicesScreenLocators());
    }
}



