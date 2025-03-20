import { Link } from "react-router-dom";
import './ServicesList.scss';

export function ServicesList({ services, search }) {
    return (
        <div className="services-list">
            {services
                .filter((s) => s.toLowerCase().includes(search.toLowerCase()))
                .map((s, i) => (
                    <Link
                        key={i}
                        to={`/${encodeURIComponent(s)}`}
                        className="service-item"
                    >
                        {s}
                    </Link>
                ))}
        </div>
    );
}
