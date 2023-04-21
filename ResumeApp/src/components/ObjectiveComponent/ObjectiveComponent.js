import React from 'react'
import "./ObjectiveComponent.css"
const ObjectiveComponent = ({objective}) => {
    
  return (
    <div id="objective-container">
        <div> <span>Career Objective : </span>{objective.obj} </div>
        <div> <span>Area Of Interest : </span>{objective.aoi} </div>
    </div>
  )
}

export default ObjectiveComponent
