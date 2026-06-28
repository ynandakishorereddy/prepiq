import { useNavigate } from 'react-router-dom';
export default function ResumeRewritesScreen() { 
  const nav = useNavigate();
  return <div className="glass-card m-lg"><h2 className="text-primary mb-md">Resume Rewrites</h2><button className="btn btn-primary" onClick={() => nav('/dashboard')}>Back to Dashboard</button></div>; 
}
