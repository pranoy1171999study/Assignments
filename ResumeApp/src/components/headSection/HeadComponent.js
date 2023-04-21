
import "./HeadComponent.css";
function Headcomponent(){
    var data={
        name:"PRANOY PATRA",
        reg:"2021MSC13",
        course:"M.Sc. Mathematics & Scientific Computing ",
        dept:"Department of Mathematics",
        college:"Motilal Nehru National Institute of Technology Allahabad"
    }
    var contacts={
        mob:"+91 9732215353/",
        alt_mob:"+91 8116460875",
        email:"📧pranoy.2021msc13@mnnit.ac.in",
        alt_email:"📧pranoypatra1171999study@gmail.com",
        linkdin:"https://www.linkedin.com/in/pranoy-patra-a4212a216/",
        adress:"Lurka,Lurka,Bankura, WB 721504"
    };
    return(
        <>
        <div className="head-container">
            <div className="inst-logo"></div>
            <div className="data">
                <h5>{data.name}</h5>
                <div>{data.reg}</div>
                <div>{data.course}</div>
                <div>{data.dept}</div>
                <div>{data.college}</div>
            </div>
            <div className="contacts">
                <div>{contacts.mob+"/"+contacts.alt_mob}</div>
                <div>{contacts.email}</div>
                <div>{contacts.alt_email}</div>
                <div>{contacts.linkdin}</div>
                <div>{contacts.adress}</div>
            </div>
            <div className="profile-pic"></div>
        </div>
        </>
    )
}

export default Headcomponent;