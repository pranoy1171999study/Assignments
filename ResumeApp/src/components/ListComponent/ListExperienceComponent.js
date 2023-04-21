import React from 'react'
import "./ListExperienceComponent.css"
const ListExperienceComponent = ({listData}) => {
    
    var contains=listData.contents;
  return (
    <div className='list-container'>
        <div id="type">{listData.type}</div>
        <ul>
        {contains.map((val, key) => {
          return (
            <li>
                <div className='duration'>{val.duration}</div>
                <div className=''><span>{val.heading}</span> ({val.short_desc})</div>
                <div className=''><span>Position:</span> {val.position}</div>
                <div className='desc'>--{val.desc}</div>
                <div></div>
            </li>
          )
        })}
        </ul>
    </div>
  )
}

export default ListExperienceComponent
