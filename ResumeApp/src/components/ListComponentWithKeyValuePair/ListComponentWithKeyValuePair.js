import React from 'react'

import "./ListComponentWithKeyValuePair.css"
const ListComponentWithKeyValuePair = ({listData}) => {
  
  

  var contains=listData.contents;
  
    return (
    <div>
    <div className='list-container'>
        <div id="type">{listData.type}</div>
        <ul>
        {contains.map((val, key) => {
          return (
            <li>
                <span className='key'>{val.key} : </span><span className='val'> {val.value}</span>
            </li>
          )
        })}
        </ul>
    </div>
  
    </div>
  )
}

export default ListComponentWithKeyValuePair
