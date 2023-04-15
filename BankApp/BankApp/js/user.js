var user={
    "customerId": 10000002,
    "fName": "Sampath",
    "lName": "Kumar Mallavelli",
    "totalBal": 0
}

var ex_accounts=$("#ex-accounts");
var ex_passbook=$("#ex-passbook");
var ex_tranjuction=$("#ex-tranjuction");


$(document).ready(function () {
    $("#sl-btn").hide();
    $("#controll").hide();
    hideAllEx();
    loadAllUsers();
});

function init(){
    $("#select-user").hide();
    $("#controll").show();
    $("#user-name").text(user.fName);
    
    $("#accounts").click(()=>{
        hideAllEx();
        ex_accounts.show();
    });
    $("#passbook").click(()=>{
        hideAllEx();
        ex_passbook.show();
    });
    $("#sendmoney").click(()=>{
        hideAllEx();
        ex_tranjuction.show();
    });
    loadAllAccounts();
    getAllTranjuctionsByUserId();
    //for sending
    $("#extf-acc-no").on('change',()=>{
        var recieverId=$("#extf-acc-no").val();
        // if(user.)
        VerifySenderAccountDetailsById(recieverId);
    })
    document.getElementById("extf-submit").addEventListener('click',()=>{
        doTranjuction();
    })
    $("#pass-choose-acc").on('change',()=>{
        setpassbookByAccNo();
    })
}
function hideAllEx(){
    ex_accounts.hide();
    ex_passbook.hide();
    ex_tranjuction.hide();
}

function loadAccountsOptions(){
    var tempHtml="";
    accounts.forEach((account)=>{
        tempHtml+='<option value="'+account.accNo+'">'+account.bank.abbrevieation+account.accNo+'</option>';
    })
    $("#extf-sender").html(tempHtml);
    $("#pass-choose-acc").html(tempHtml);
}
function prepareForSendingMoney(){
    loadAccountsOptions();
    getAllBanks();
}
function openController(){
    var cid=$("#selectUserID").val();
    customers.forEach((cst)=>{
        if(Number(cst.customerId)==Number(cid)){
            user=cst;
        }
    })
    init();
}

// server requests
var customers;
function loadAllUsers(){
    var settings = {
        "url": "http://localhost:8080/customer",
        "method": "GET",
        "timeout": 0,
      };
      
      $.ajax(settings).done(function (response) {
        customers=response;
        tempHtml="";
        customers.forEach((customer)=>{
            tempHtml+='<option value="'+customer.customerId+'">UID'+customer.customerId+" "+customer.fName+'</option>';
        })
        $("#selectUserID").html(tempHtml);
        $("#sl-btn").show();
      });
    
}
var accounts=null;
function loadAllAccounts(){
    var settings = {
        "url": "http://localhost:8080/account/customer/"+user.customerId,
        "method": "GET",
        "timeout": 0,
      };
      
      $.ajax(settings).done(function (response) {
        accounts=response;
        if(accounts!=null){
            console.log(accounts[0]);
            TempPassbookWithUser.accNo=accounts[0].accNo;
        }
        
        var tempHtml="";
        var totalbal=0;
        accounts.forEach(account => {
            totalbal+=account.balance;
            tempHtml+='<tr>'+
            '<th ><div class="paper-dot"></div></th>'+
            '<td class="abb">'+account.bank.abbrevieation+'</td>'+
            '<td class="acc">'+account.accNo+'</td>'+
            '<td class="bal">'+account.balance+'</td>'+
        '</tr>';
        });
        tempHtml+='<tr>'+
        '<td ></td>'+
        '<td></td>'+
        '<td></td>'+
        '<td id="total" class="bal">'+totalbal+'</td>'+
    '</tr>';

        $("#tab-acc").html(tempHtml);
        prepareForSendingMoney();
        setpassbookByAccNo();
      });
}
var tranjuctions;
function getAllTranjuctionsByUserId(){
    var settings = {
        "url": "http://localhost:8080/tranjuction/customer/"+user.customerId,
        "method": "GET",
        "timeout": 0,
      };
      
      $.ajax(settings).done(function (response) {
        tranjuctions=response;
        setPassBook();
      });
}
var currentPassbookAcc;
function setPassBook(){
    currentPassbookAcc=$("#pass-choose-acc").val();
    if(currentPassbookAcc!=null){
        setpassbookByAccNo();
    }
}
var TempPassbookWithUser={
    accNo: -1,
    currPage:0,
    maxPage:5
}
function prev(){
    if(TempPassbookWithUser.currPage>0){
        TempPassbookWithUser.currPage-=1;
        setpassbookByAccNo();
    }
}
function next(){
    if(TempPassbookWithUser.currPage<TempPassbookWithUser.maxPage-1){
        TempPassbookWithUser.currPage+=1;
        setpassbookByAccNo();
    }
}
var pageSize=5;
function setpassbookByAccNo(){
    if(TempPassbookWithUser.accNo!=-1){
        if(TempPassbookWithUser.accNo!=$("#pass-choose-acc").val()){
            TempPassbookWithUser.accNo=$("#pass-choose-acc").val();
            TempPassbookWithUser.currPage=0;
        }
        var settings = {
            "url": "http://localhost:8080/tranjuction/acc/"+TempPassbookWithUser.accNo+"/page?pageno="+TempPassbookWithUser.currPage+"&size="+pageSize,
            "method": "GET",
            "timeout": 0,
          };
          
          $.ajax(settings).done(function (response) {
            TempPassbookWithUser.maxPage=response.totalPages;
            var releventTrs=response.content;
            var tempHtml='<tr>'+
            '<th ></th>'+
            '<th>Id</th>'+
            '<th>Acc No</th>'+
            '<th>Remerks</th>'+
            '<th>Amount</th>'+
            '<th>Time</th>'+
            '</tr>';
            var checker=false;
            var setClass="red";
            releventTrs.forEach((tr)=>{
                checker=true;
                if(Number(tr.sender)==Number(currentPassbookAcc)){
                    setClass="red";
                }else{
                    setClass="green";
                }
                    tempHtml+='<tr>'+
                    '<td ><div class="paper-dot"></div></td>'+
                    '<td>TR'+tr.trId+'</td>'+
                    '<td>'+tr.sender+'</td>'+
                    '<td>'+tr.reciever+'</td>'+
                    '<td class="'+setClass+'">'+tr.amount+'</td>'+
                    '<td>'+tr.time+'</td>'+
                '</tr>';
                })
                if(!checker){
                    tempHtml="No Transactions Done Yet To Show"
                }
                $("#tab-pass").html(tempHtml);
                });
    }
    
    
}
function getAllBanks(){
    var settings = {
        "url": "http://localhost:8080/bank",
        "method": "GET",
        "timeout": 0,
      };
      
      $.ajax(settings).done(function (response) {
        var tempHtml="";
        response.forEach((bank)=>{
            tempHtml+='<option value="'+bank.abbrevieation+'">'+bank.abbrevieation+'</option>';
        })
        $("#extf-sender-bank").html(tempHtml);
      });
}
var verifiedSenderDetails=false;
function VerifySenderAccountDetailsById(id){
    var settings = {
        "url": "http://localhost:8080/account/"+id,
        "method": "GET",
        "timeout": 0,
      };
      
      $.ajax(settings).done(function (response) {
        if(response==null){
            return;
        }
        var inputBank=$("#extf-sender-bank").val();
        var bank=response.bank.abbrevieation;
        var customerName=response.c_id.fName+" "+response.c_id.lName;
        if(inputBank===bank&&!checkSelectedAccountIsOfUser(id)){
            $("#extf-sender-name").text(customerName+" ("+bank+")");
            verifiedSenderDetails=true;
        }
        else{
            $("#extf-sender-name").text("Invalid User");
            verifiedSenderDetails=false;
        }
      });
}
function checkSelectedAccountIsOfUser(uAcc){
    if($("#extf-sender").val()===uAcc){
        return true;
    }
    return false;
}
function doTranjuction(){
    if(verifiedSenderDetails){
        var sender=$("#extf-sender").val();
        var reciever=$("#extf-acc-no").val();
        var amount=$("#extf-amount").val();
        var settings = {
            "url": "http://localhost:8080/tranjuction/transfer?sender="+sender+"&reciever="+reciever+"&amount="+amount,
            "method": "PUT",
            "timeout": 0,
          };
          
          $.ajax(settings).done(function (response) {
            alert(response);
            init();
          });
    }else{
        alert("Wrong Data");
    }
}

