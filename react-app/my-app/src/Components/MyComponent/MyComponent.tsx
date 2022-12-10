import React, { FC } from 'react';
import styles from './MyComponent.module.css';

interface MyComponentProps {}

const MyComponent: FC<MyComponentProps> = () => (
  <div className={styles.MyComponent}>
    MyComponent Component
  </div>
);

export default MyComponent;
