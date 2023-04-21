import React from 'react'

const GenerateTBodyComponent = ({degree}) => {
   return (
    <>
        {degree.map((val, key) => {
          return (
            <tr>
              <td>{val.degree}</td>
              <td>{val.inst}</td>
              <td>{val.marks}</td>
              <td>{val.year}</td>
            </tr>
          )
        })}
    </>
  )
}

export default GenerateTBodyComponent
