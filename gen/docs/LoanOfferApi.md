# LoanOfferApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**calculateLoanOffers**](LoanOfferApi.md#calculateLoanOffers) | **POST** /conveyor/offers | 


<a name="calculateLoanOffers"></a>
# **calculateLoanOffers**
> List&lt;LoanOfferDTO&gt; calculateLoanOffers(loanApplicationRequestDTO)



������� ������

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.LoanOfferApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    LoanOfferApi apiInstance = new LoanOfferApi(defaultClient);
    LoanApplicationRequestDTO loanApplicationRequestDTO = new LoanApplicationRequestDTO(); // LoanApplicationRequestDTO | 
    try {
      List<LoanOfferDTO> result = apiInstance.calculateLoanOffers(loanApplicationRequestDTO);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling LoanOfferApi#calculateLoanOffers");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **loanApplicationRequestDTO** | [**LoanApplicationRequestDTO**](LoanApplicationRequestDTO.md)|  |

### Return type

[**List&lt;LoanOfferDTO&gt;**](LoanOfferDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | success |  -  |

