import React from 'react'
import "./EducationComponent.css";
import GenerateTBodyComponent from './GenerateTBodyComponent';
const EducationComponent = ({degree}) => {
    
    
    
  return (
    <div>
      <table>
        <tr>
            <th>Degree/Certificate</th>
            <th>Institute/Board</th>
            <th>Marks</th>
            <th>Year</th>
        </tr>
        <GenerateTBodyComponent degree={degree}/>
        
      </table>
    </div>
  )
}


export default EducationComponent
