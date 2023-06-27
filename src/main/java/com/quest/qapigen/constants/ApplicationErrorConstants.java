package com.quest.qapigen.constants;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@PropertySource("classpath:/error_messages.properties")
@Component
public class ApplicationErrorConstants {

	public static String SUBSCRIPTION_DOESNOT_EXIST_FOR_ORDER;

	public static String CUSTOMERID_NOT_ASSOCIATED_WITH_SUBSCRIPTION;

	public static String ERRSTATUS400;

	public static String ERRSTATUS401;

	public static String ERRSTATUS404;

	public static String ERRSTATUS500;

	public static String INVALID_CUSTOMER_ID;

	public static String INVALID_SUBSCRIPTION_ID;

	public static String INTERNAL_ERROR_EXCEPTION;

	public static String NO_MORE_RECORDS_AVAILABLE;

	public static String PAYMENT_HISTORY_IS_NOT_AVAILABLE;

	public static String SUBSCRITPTIONS_NOT_FOUND;

	public static String SUBSCRITPTION_NOT_FOUND;

	public static String HP_ID_OR_SUBSCRIPTION_ID_IS_NULL_EMPTY;

	public static String REQUEST_PARAM_IS_MAL_FORMED;

	public static String ENTITY_TO_DTO_EXCEPTION;

	public static String INVALID_PAYMENT_PROCESSOR;

	public static String UNABLE_CREATE_CONTRACT_ACCOUNT;

	public static String UNABLE_CREATE_SUBSCRIPTION;

	public static String UNABLE_CANCEL_SUBSCRIPTION;
	
	public static String UNABLE_UPDATE_PAYMENT_METHOD;

	public static String SUBSCRIPTIONS_NOT_FOUND_FOR_ORDERID;

	public static String SUBSCRIPTIONKEY_DOESNOT_EXIST_FOR_SUBSCRIPTION;

	public static String FAILURE_FROM_BRIM;
	
	public static String UNABLE_DELETE_ORDER;
	
	public static String INVALID_CLIENTID;

	public static String UNABLE_CREATE_IWC_BILLING_EVENT;

	@Value("${subscription_doesnot_exist_for_order}")
	private String subscriptionDoesnotExistForOrder;

	@Value("${customerid_not_associated_with_subscription}")
	private String customeridNotAssociatedWithSubscription;

	@Value("${invalid_customer_id}")
	private String invalidCustomerId;

	@Value("${invalid_subscription_id}")
	private String invalidSubscriptionId;

	@Value("${internal_error_exception}")
	private String internalErrorException;

	@Value("${subscriptions_not_found}")
	private String subscriptionsNotFound;

	@Value("${subscription_not_found}")
	private String subscriptionNotFound;

	@Value("${no_more_records_available}")
	private String noMoreRecordsAvailable;

	@Value("${payment_history_not_available}")
	private String paymentHistoryIsNotAvailable;

	@Value("${hpId_or_subscriptionId_isNullEmpty}")
	private String hpIdOrSubscriptionIdIsNullEmpty;

	@Value("${request_param_is_malformed}")
	private String requestParamIsMalformed;

	@Value("${entity_to_dto_exception}")
	private String entityToDtoException;

	@Value("${invalid_payment_processor}")
	private String invalidPaymentProcessor;

	@Value("${unable_create_contract_account}")
	private String unableCreateContractAccount;

	@Value("${unable_create_subscription}")
	private String unableCreateSubscription;

	@Value("${unable_cancel_subscription}")
	private String unableCancelSubscription;
	
	@Value("${unable_update_payment_method}")
	private String unableUpdatePaymentMethod;

	@Value("${kinesis_exception}")
	private String kinesisException;

	@Value("${subscriptions_not_found_for_orderId}")
	private String subscriptionsNotFoundForOrderId;

	public static String KINESIS_PROPERTY_EXCEPTION;

	@Value("${subscription_key_doesnot_exist_for_subscription}")
	private String subscriptionKeyDoesnotExistForSubscription;

	@Value("${failure_from_brim}")
	private String failureFromBrim;
	
	@Value("${unable_delete_order}")
	private String unableDeleteOrder;

	@Value(("${SHORT_DESCRIPTION_404}"))
	private String notFoundError;

	@Value(("${SHORT_DESCRIPTION_400}"))
	private String badRequestError;

	@Value("${unable_iwc_billing_event}")
	private String unableIwcBillingEvent;

	public static String MANDATORY_FIELD;
	public static String INVALID_COUNTRY;
	public static String INVALID_CURRENCY;
	public static String INVALID_BOOLEAN_INPUT;
	public static String INVALID_SUBSCRIPTION_DATE;
	public static String INVALID_LOCALE_PATTERN;
	public static String INVALID_PAYMENT_GATEWAY;
	public static String INVALID_CONSENT_DATE;
	public static String INVALID_HW_SKU;
	public static String NOT_FOUND;
	public static String BAD_REQUEST;

	@Value("${mandatory_field}")
	private String mandatoryField;

	@Value("${invalid_country}")
	private String invalidCountry;

	@Value("${invalid_currency}")
	private String invalidCurrency;

	@Value("${invalid_boolean_input}")
	private String invalidBooleanInput;

	@Value("${invalid_subscription_date}")
	private String invalidSubscriptionDate;

	@Value("${invalid_locale}")
	private String invalidLocale;

	@Value("${invalid_payment_gateway}")
	private String invalidPaymentGateway;

	@Value("${invalid_consent_date}")
	private String invalidConsentDate;
	
	public static final String INVALID_FIRST_NAME_SIZE = "First name can not have more than 50 characters";
	public static final String INVALID_FIRST_NAME = "First name contains invalid characters.";

	public static final String INVALID_LAST_NAME_SIZE = "Last name can not have more than 50 characters";
	public static final String INVALID_LAST_NAME = "Last name contains invalid characters.";
	public static final String INVALID_HPID = "HPID can not have more than 100 characters";
	public static final String INVALID_LOCALE = "Locale can not have more than 100 characters";
	public static final String INVALID_PAYMENT_TYPE_SIZE = "Payment type can not have more than 50 characters";
	public static final String INVALID_PAYMENT_TYPE = "Payment type contains invalid characters.";
	
	public static final String INVALID_PAYMENT_LAST_FOUR_SIZE = "Payment last four  can not have more than 4 characters";
	public static final String INVALID_PAYMENT_LAST_FOUR = "Payment last four contains invalid characters.";
	public static final String INVALID_PAYMENT_PROCESSOR_SIZE = "Payment processor can not have more than 50 characters";
	public static final String INVALID_PAYMENT_PROCESSOR_MESSAGE = "Payment processor contains invalid characters.";

	public static final String INVALID_PAYMENT_EXPIRY_DATE = "Payment expiry date contains invalid characters.";
	public static final String INVALID_PAYMENT_EXPIRY_DATE_SIZE = "Payment expiry date can not have more than 20 characters";
	public static final String INVALID_PAYMENT_GATEWAY_SIZE = "Payment gate way can not have more than 50 characters";
	public static final String INVALID_PAYMENT_TOKEN_SIGNATURE = "Token signature contains invalid characters.";
	public static final String INVALID_PAYMENT_TOKEN ="Token contains invalid characters.";
	public static final String INVALID_PAYMENT_CARD_HOLDER_NAME ="Card holder name contains invalid characters.";
	public static final String INVALID_PAYMENT_CARD_HOLDER_NAME_SIZE = "Card holder name can not have more than 100 characters";

	public static final String INVALID_EXTERNAL_REF_FIELD_NAME = "External ref field name contains invalid characters.";
	public static final String INVALID_EXTERNAL_REF_VALUE_NAME = "External ref value contains invalid characters.";
	public static final String INVALID_PRODUCT_NAME_SIZE = "Product name can not have more than 100 characters";
	public static final String INVALID_DSP_PRODUCT_NAME_SIZE = "Product name can not have more than 100 characters for itemId %s.";
	public static final String INVALID_SKU_SIZE = "SKU can not have more than 50 characters";
	public static final String INVALID_PROMO_CODE_SIZE = "Promo code can not have more than 50 characters";

	public static final String INVALID_ORDER_ITEM = "Item has validation error.";
	public static final String INVALID_ITEM_ID = "Item id %s is invalid, Item id should be in between 001 to 999.";
	public static final String INVALID_PRODUCT_NAME = "Product name contains invalid characters.";
	public static final String INVALID_DSP_PRODUCT_NAME = "Product name contains invalid characters for itemId %s.";
	public static final String INVALID_SKU = "SKU contains invalid characters.";
	public static final String INVALID_PROMO_CODE = "Promo code contains invalid characters.";

	public static final String INVALID_TAX_NUMBER_SIZE =  "Tax number can not have more than 50 characters";
	public static final String INVALID_TAX_TYPE_SIZE =  "Tax type can not have more than 50 characters";
	public static final String INVALID_TAX_NUMBER =  "Tax number contains invalid characters.";
	public static final String INVALID_TAX_TYPE =  "Tax type contains invalid characters.";
	public static final String INVALID_ADDRESS1 = "Address1 contains invalid characters.";
	public static final String INVALID_ADDRESS2 = "Address2 contains invalid characters.";
	public static final String INVALID_CITY = "City contains invalid characters.";
	public static final String INVALID_COUNTRY_CODE = "Country code contains invalid characters.";
	public static final String INVALID_PHONE_NUMBER = "Phone number contains invalid characters.";
	public static final String INVALID_ZIP_CODE ="Zip code contains invalid characters.";
	public static final String INVALID_STATE_PROVINCE = "State province contains invalid characters.";
	public static final String INVALID_CLIENT_ID_SIZE ="Client id can not have more than 100 characters";
	public static final String INVALID_ORDER_ID_SIZE = "Order id can not have more than 100 characters";
	public static final String INVALID_COUNTRY_SIZE = "Country code can not have more than 50 characters";
	public static final String INVALID_CURRENCY_SIZE ="Currency code can not have more than 50 characters";
	public static final String INVALID_PAYMENT_TOKEN_SIZE = "Token can not have size more than 255 characters";
	public static final String INVALID_TOKEN_SIGNATURE_SIZE = "Token can signature not have size more than 255 characters";
	public static final String SUBSCRIPTION_ALREADY_CANCELLED = "Subscription already cancelled.";
	public static final String INVALID_ORDER_ID = " Order id contains invalid characters.";
	public static final String AUTO_RENEW_ALREADY_STOP = "Subscription already Stopped.";
	public static final String AUTO_RENEW_ALREADY_START = "Subscription already Started.";
	public static final String INVALID_REQUEST_DATA = "BAD Request, Invalid Request Data";
	public static final String EXCEPTION_LOGGER = "Exception occurred while processing records {}";
	public static final String EVENT_EXCEPTION_LOGGER = "Exception while publishing Event {}";
	public static final String INVALID_FIELD_NAME_SIZE = "Field Name cannot contain more than 20 characters.";
	public static final String INVALID_FIELD_NAME_VALUE_SIZE = "Field Value cannot contain more than 100 characters.";
	public static final String INVALID_DIVISION_ID = "Division contains invalid characters.";
	public static final String INVALID_DISTRIBUTION_CHANNEL_ID = "Distribution channel contains invalid characters.";
	public static final String INVALID_SALES_ORGANIZATION_ID = "Sales Organization contains invalid characters.";
	
	public static final String INVALID_PO_SIZE = " PO Number can not have more than 100 characters";
	public static final String INVALID_SHIPTO_BPID_SIZE = "SHIPTOBPID can not have more than 100 characters";
	public static final String INVALID_SOLDTO_BPID_SIZE = "SOLDTOBPID can not have more than 100 characters";
	public static final String INVALID_PAYMENT_TERM_SIZE = " Payment Term can not have more than 100 characters";
	
	public static final String INVALID_PO_NAME ="PO field contains invalid characters.";
	public static final String INVALID_SHIP_TO_BPID_NAME ="SHIPTOBPID contains invalid characters.";
	public static final String INVALID_SOLD_TO_BPID_NAME ="SOLDTOBPID contains invalid characters.";
	public static final String INVALID_PAYMENT_TERM_NAME ="Payment term contains invalid characters.";
	public static final String INVALID_AMOUNT = "must be greater than 0";
	public static final String INVALID_FREQUENCY_LENGTH = "must be 1";
	public static final String INVALID_HP_ID_PATTERN = "HP ID contains invalid characters.";
	public static final String INVALID_HP_ID = "HP ID mismatch";
	public static final String INVALID_LENGTH_HP_ID_PATTERN = "HpId list size should not be more than 10";
	public static final String CLIENT_ID_MISMATCH = "Client Id mismatch";
	public static final String INVALID_EMAIL_ID= "invalid emailId";
	public static final String INVALID_ORDER_ITEMS = "The order items are not valid.Please, enter the valid order item details.";
	public static final String EMPTY_HPID = "HpId is mandatory. It must not be empty or blank";
	public static final String INVALID_PAGE_NO = "Invalid page no received";
	public static final String INVALID_ITEM_TYPE = "Item type is invalid, Item type must contain only alphabets for itemId %s";
	public static final String INVALID_ITEM_TYPE_DSP_BUNDLE = "Item type is invalid, Item type must contain only dsp_bundle for itemId %s.";
	public static final String INVALID_ITEM_TYPE_DSP_OFFER = "Item type is invalid, Item type must contain only dsp_offer for itemId %s.";
	public static final String INVALID_HW_SHIPPING_DURATION_DAYS = "must be equal or greater than 0";
	public static final String INVALID_UNIT = "Invalid frequency unit. Please enter only Month/Year";
	public static final String MISSING_ORDER_FAILURE_MESSAGE = "The following BI recon order was not received by Gekko: %s.";
	public static final String MANDATORY_DSP_ITEM_TYPE = "Item type is mandatory. It must not be empty or blank for itemId %s.";
	public static final String MANDATORY_DSP_PRODUCT_NAME = "Product name is mandatory. It must not be empty or blank for itemId %s.";
	public static final String INVALID_COLLECTION_DATE = "Collection Date contains invalid characters. Date Should be in YYYY-MM-DD HH:MM:SS.SSS format";
	public static final String INVALID_BILLING_PERIOD_START = "Billing Period Start contains invalid characters.";
	public static final String INVALID_BILLING_PERIOD_END = "Billing Period End contains invalid characters.";
	public static final String INVALID_SOURCE_ID = "Source id contains invalid characters.";
	public static final String INVALID_BP_ID = "BP id contains invalid characters.";
	public static final String INVALID_MATERIAL = "Material contains invalid characters.";
	public static final String INVALID_QUANTITY = "Quantity must be greater than 0";
	public static final String CANCEL_DATE_FORMAT_ERROR_MESSAGE = "Incorrect time format provide at cancelledAt,please provide in YYYY-MM-DDT00:00:00+00:00 format";
	public static final String SUBSCRIPTION_NOT_FOUND_FOR_FALLOUT_ORDER= "Subscription was not found for fallout order %s.";
	public static final String CANCELLEDAT_DATE_MISSING_ERROR_MESSAGE = "CancelledAt date is missing in the request";
	public static final String CANCELLEDAT_DATE_GREATERTHAN_ENDDATE_ERROR = "Renewal is in-progress for this subscription, and Subscription End Date is greater than Cancellation date, so we won't be able to cancel it";
	public static final String EMPTY_DISTRIBUTION_CHANNEL_ID = "Distribution channel is mandatory. It must not be empty or blank.";
	public static final String MOCK_ENDPOINT_SUBSCRIPTION_FAILURE_NO_RESPONSE ="No Response for Create Subscription";
	public static final String MOCK_ENDPOINT_IWC_BILLING_FAILURE_NO_RESPONSE = "No Response for Iwc Billing";
	public static final String INVALID_CURRENCY_CODE = "Currency code contains invalid characters.";
	
	@PostConstruct
	public void init() {
		ApplicationErrorConstants.SUBSCRIPTION_DOESNOT_EXIST_FOR_ORDER = subscriptionDoesnotExistForOrder;
		ApplicationErrorConstants.CUSTOMERID_NOT_ASSOCIATED_WITH_SUBSCRIPTION = customeridNotAssociatedWithSubscription;
		ApplicationErrorConstants.ERRSTATUS400 = String.valueOf(HttpStatus.BAD_REQUEST.value());
		ApplicationErrorConstants.ERRSTATUS401 = String.valueOf(HttpStatus.UNAUTHORIZED);
		ApplicationErrorConstants.ERRSTATUS404 = String.valueOf(HttpStatus.NOT_FOUND);
		ApplicationErrorConstants.INVALID_CUSTOMER_ID = invalidCustomerId;
		ApplicationErrorConstants.INVALID_SUBSCRIPTION_ID = invalidSubscriptionId;
		ApplicationErrorConstants.ERRSTATUS500 = String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR);
		ApplicationErrorConstants.INTERNAL_ERROR_EXCEPTION = internalErrorException;
		ApplicationErrorConstants.NO_MORE_RECORDS_AVAILABLE = noMoreRecordsAvailable;
		ApplicationErrorConstants.PAYMENT_HISTORY_IS_NOT_AVAILABLE = paymentHistoryIsNotAvailable;
		ApplicationErrorConstants.SUBSCRITPTIONS_NOT_FOUND = subscriptionsNotFound;
		ApplicationErrorConstants.SUBSCRITPTION_NOT_FOUND = subscriptionNotFound;
		ApplicationErrorConstants.HP_ID_OR_SUBSCRIPTION_ID_IS_NULL_EMPTY = hpIdOrSubscriptionIdIsNullEmpty;
		ApplicationErrorConstants.REQUEST_PARAM_IS_MAL_FORMED = requestParamIsMalformed;
		ApplicationErrorConstants.ENTITY_TO_DTO_EXCEPTION = entityToDtoException;
		ApplicationErrorConstants.INVALID_PAYMENT_PROCESSOR = invalidPaymentProcessor;
		ApplicationErrorConstants.UNABLE_CREATE_CONTRACT_ACCOUNT = unableCreateContractAccount;
		ApplicationErrorConstants.UNABLE_CANCEL_SUBSCRIPTION = unableCancelSubscription;
		ApplicationErrorConstants.UNABLE_UPDATE_PAYMENT_METHOD = unableUpdatePaymentMethod;
		ApplicationErrorConstants.KINESIS_PROPERTY_EXCEPTION = kinesisException;
		ApplicationErrorConstants.SUBSCRIPTIONS_NOT_FOUND_FOR_ORDERID = subscriptionsNotFoundForOrderId;
		ApplicationErrorConstants.SUBSCRIPTIONKEY_DOESNOT_EXIST_FOR_SUBSCRIPTION = subscriptionKeyDoesnotExistForSubscription;
		ApplicationErrorConstants.UNABLE_CREATE_SUBSCRIPTION = unableCreateSubscription;
		ApplicationErrorConstants.FAILURE_FROM_BRIM = failureFromBrim;
		ApplicationErrorConstants.UNABLE_DELETE_ORDER = unableDeleteOrder;

		ApplicationErrorConstants.MANDATORY_FIELD = mandatoryField;
		ApplicationErrorConstants.INVALID_COUNTRY = invalidCountry;
		ApplicationErrorConstants.INVALID_CURRENCY = invalidCurrency;
		ApplicationErrorConstants.INVALID_BOOLEAN_INPUT = invalidBooleanInput;
		ApplicationErrorConstants.INVALID_SUBSCRIPTION_DATE = invalidSubscriptionDate;
		ApplicationErrorConstants.INVALID_LOCALE_PATTERN = invalidLocale;
		ApplicationErrorConstants.INVALID_PAYMENT_GATEWAY = invalidPaymentGateway;
		ApplicationErrorConstants.INVALID_CONSENT_DATE = invalidConsentDate;
		ApplicationErrorConstants.NOT_FOUND = notFoundError;
		ApplicationErrorConstants.BAD_REQUEST = badRequestError;
		ApplicationErrorConstants.UNABLE_CREATE_IWC_BILLING_EVENT = unableIwcBillingEvent;
	}
}
