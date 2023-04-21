import logo from './logo.svg';
import './App.css';
import Headcomponent from './components/headSection/HeadComponent';
import ObjectiveComponent from './components/ObjectiveComponent/ObjectiveComponent';
import EducationComponent from './components/EducationComponent/EducationComponent';
import ListExperienceComponent from './components/ListComponent/ListExperienceComponent';
import ListComponentWithKeyValuePair from './components/ListComponentWithKeyValuePair/ListComponentWithKeyValuePair';

var degree=[
  {
      degree:"M.Sc. Mathematics & Scientific Computing",
      inst:"Motilal Nehru National Institute of Technology Allahabad",
      marks:"7.31(Present)/10",
      year:2023
  },
  {
      degree:"B.Sc. (Hons) Mathematics",
      inst:"Vidyasagar University",
      marks:"6.9/10",
      year:2020
  },
  {
      degree:"Higher Secondary",
      inst:"West Bengal Council of Higher Secondary Education",
      marks:"80%",
      year:2017
  },
  {
      degree:"Madhyamik(Secondary)",
      inst:"West Bengal Board of Secondary Education",
      marks:"81.7%",
      year:2015
  }
]
var experience={
  type:"Experience",
  contents:[
      {
          heading:"The Sparks Foundation",
          short_desc:"A non-profit education management industry based in Singapore",
          position:"Web Development Intern",
          duration:"June 2022 - July 2022",
          desc:"Developed a responsive & dynamic website Spark Bank: Basic Banking System using HTML, CSS, JS, PHP & MySQL"
      },
      {
          heading:"Chegg",
          short_desc:"Chegg is the leading student-first interconnected learning platform",
          position:"Freelancer",
          duration:"Apr-21 to current",
          desc:"-providing solutions of subject wise questions"
      }
  ]
}
var objective={
  obj:"To secure a challenging position in a reputable organization to expand my learnings, knowledge and skills and make something different.",
  aoi:"Software Development "
}
var techSkills={
  type:"Technical Skills",
  contents:[
      {
          key:"Programming Languages",
          value : "C, C++(Oops) "
      },
      {
          key:"Web Technologies",
          value:"HTML, CSS, PHP, JavaScript ,APIS (REST),NodeJs"
      },
      {
          key:"Database Management",
          value: "DBMS, MySQL"
      },
      {
          key:"Data structures and algorithms",
          value: "C/C++"
      }
  ]
}

var Projects={
  type:"Projects",
  contents:[
      {
          key:"Sort Visualizer",
          value : "[ HTML,CSS,JS ] __a custom sort visualizer to understand DSA Sort concept]"
      },
      {
        key:"Spotify Clone",
        value : "[ HTML,CSS,JS,PHP,MySQL ] __a music streamming app inspired by the design of Spotify"
    }
  ]
}
var KeyCourse={
  type:"Key Course Taken",
  contents:[
      {
          key:"Computer Science:",
          value : "Computer Programming (with Lab)(C & C++), Data Structures & Algorithms (with Lab)"
      },
      {
        key:"Mathematics",
        value:" Numerical Analysis , Probability & Statistics"
      },
      {
        key:"Online Courses:",
        value:"Web Development(html, CSS , js ,bootstrap, AJAX basics)"
      }
  ]
}
var achievements={
  type:"Achievements",
  contents:[
    {
      key:"JAM 2021",
      value : "AIR 652"
    },
    {
      key:"Hacker Rank",
      value : "5⭐ in c++"
    }
  ]
}
var softSkills={
  type:"Soft Skills",
  contents:[
    {
      key:"",
      value : "-Adaptability"
    },
    {
      key:"",
      value : "-Problem Solving"
    },
    {
      key:"",
      value : "-Time Management"
    }
  ]
}
function App() {
  return (
    <div className="App">
      <Headcomponent/>
      <ObjectiveComponent objective={objective}/>
      <EducationComponent degree={degree}/>
      <ListExperienceComponent listData={experience}/>
      <ListComponentWithKeyValuePair listData={techSkills}/>
      <ListComponentWithKeyValuePair listData={Projects}/>
      <ListComponentWithKeyValuePair listData={KeyCourse}/>
      <ListComponentWithKeyValuePair listData={achievements}/>
      <ListComponentWithKeyValuePair listData={softSkills}/>
    </div>
  );
}

export default App;
